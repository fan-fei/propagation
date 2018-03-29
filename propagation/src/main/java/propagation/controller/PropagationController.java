package propagation.controller;

import javax.ws.rs.BeanParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import propagation.entity.User;
import propagation.service.PropagationService1;

@Controller
@RequestMapping(path = "/propagation")
public class PropagationController {

    @Autowired
    private PropagationService1 propagationService1;

    @GetMapping(path = "/add")
    public @ResponseBody User add(@BeanParam User user) {
        return propagationService1.save(user);
    }

    @GetMapping(path = "/delete")
    public @ResponseBody Boolean delete(@RequestParam Long id) {
        propagationService1.delete(id);
        return true;
    }

    @GetMapping(path = "/update")
    public @ResponseBody User update(@BeanParam User user) {
        return propagationService1.save(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return propagationService1.findAll();
    }

    @GetMapping(path = "/save")
    public @ResponseBody User save(@BeanParam User user) {
        User userResult = new User();
        try {
            userResult = propagationService1.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userResult;
    }
}