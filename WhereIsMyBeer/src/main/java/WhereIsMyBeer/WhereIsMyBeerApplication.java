package WhereIsMyBeer;

import WhereIsMyBeer.configuration.CsrfHeaderFilter;
import WhereIsMyBeer.configuration.SecurityUserDetailsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableWebSecurity
@EnableRedisHttpSession
public class WhereIsMyBeerApplication {

    private static final Logger LOGGET = Logger.getLogger(WhereIsMyBeerApplication.class);

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        private SecurityUserDetailsService securityUserDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/images", "/images/**").permitAll()
                    .antMatchers("/photos", "/photos/**").permitAll()
                    .antMatchers("/fonts", "/fonts/**").permitAll()
                    .antMatchers("/css", "/css/**").permitAll()
                    .antMatchers("/js", "/js/**").permitAll()
                    .antMatchers("/controller", "/controller/**").permitAll()
                    .antMatchers("/usuario.html", "/usuario/**").permitAll()
                    .antMatchers("/index.html", "/home.html", "/login.html","/").permitAll()
                    .anyRequest().authenticated().and()
                    .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
                    .csrf().csrfTokenRepository(csrfTokenRepository());
        }

        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

            auth.userDetailsService(securityUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }

        @RequestMapping("/token")
        public Map<String,String> token(HttpSession session) {
            System.out.println(session.getId());
            System.out.println(session.getCreationTime());
            return Collections.singletonMap("token", session.getId());
        }

        @RequestMapping("/user")
        public Principal user(Principal user) {
            return user;
        }

        @Bean
        public HeaderHttpSessionStrategy sessionStrategy() {
            return new HeaderHttpSessionStrategy();
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(WhereIsMyBeerApplication.class, args);
    }
}
