package WhereIsMyBeer.controller;

import WhereIsMyBeer.model.User;
import WhereIsMyBeer.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by micdomingues on 23/12/2015.
 */
@RestController
@RequestMapping("usuario/")
public class UserController extends GenericController<User,Long>{

    @Autowired
    UserDAO userDAO;

    @Autowired
    public UserController(UserDAO dao) {
        super(dao);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
//        System.out.println(user.getName());
        return user;
    }

    @RequestMapping("/resource")
    public Map<String,Object> home(){
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content","Hello World");
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User create(@RequestParam("email") String email, @RequestParam("nome") String nome){
        User user = null;
        String userId = "";
        try{
            user = new User(email,nome);
            userDAO.save(user);
        }catch (Exception ex){
            return user;
        }
        return user;
    }

}
