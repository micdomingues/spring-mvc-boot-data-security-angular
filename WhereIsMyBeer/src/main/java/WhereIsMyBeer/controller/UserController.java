package WhereIsMyBeer.controller;

import WhereIsMyBeer.model.User;
import WhereIsMyBeer.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by micdomingues on 23/12/2015.
 */
@RestController
@RequestMapping("usuario/")
public class UserController{

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
