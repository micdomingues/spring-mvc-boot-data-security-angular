package WhereIsMyBeer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by micdomingues on 21/12/2015.
 */
@Transactional
public abstract class GenericController<T, ID extends Serializable>{

    private Logger logger = LoggerFactory.getLogger(GenericController.class);

    private CrudRepository<T, ID> dao;

    public GenericController(CrudRepository<T, ID> dao) {
        this.dao = dao;
    }


    @RequestMapping
    public @ResponseBody List<T> listAll() {
        Iterable<T> all = this.dao.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
    }

    @RequestMapping(method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> create(@RequestBody T json) {
        logger.debug("create() with body {} of type {}", json, json.getClass());

        T created = this.dao.save(json);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("success", true);
        m.put("created", created);
        return m;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody T get(@PathVariable ID id) {
        return this.dao.findOne(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Map<String, Object> update(@PathVariable ID id, @RequestBody T json) {
        logger.debug("update() of id#{} with body {}", id, json);
        logger.debug("T json is of type {}", json.getClass());

        T entity = this.dao.findOne(id);
        try {
            BeanUtils.copyProperties(entity, json);
        }
        catch (Exception e) {
            logger.warn("while copying properties", e);
            logger.error("while copying properties", e);
        }

        logger.debug("merged entity: {}", entity);

        T updated = this.dao.save(entity);
        logger.debug("updated enitity: {}", updated);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("success", true);
        m.put("id", id);
        m.put("updated", updated);
        return m;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete(@PathVariable ID id) {
        this.dao.delete(id);
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("success", true);
        return m;
    }


//    @RequestMapping("/user")
//    public Principal user(Principal user) {
//        return user;
//    }
//
//    @RequestMapping("/resource")
//    public Map<String,Object> home(){
//        Map<String,Object> model = new HashMap<String,Object>();
//        model.put("id", UUID.randomUUID().toString());
//        model.put("content","Hello World");
//        return model;
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public User create(@RequestParam("email") String email, @RequestParam("nome") String nome){
//        User user = null;
//        String userId = "";
//        try{
//            user = new User(email,nome);
//            dao.save(user);
//            userId = String.valueOf(user.getId());
//        }catch (Exception ex){
//            return user;
//        }
//        return user;
//    }
}
