package propagation.controller;

import javax.ws.rs.BeanParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import propagation.entity.User;
import propagation.service.PropagationService;

@Controller
@RequestMapping(path = "/propagation")
public class PropagationController {

    @Autowired
    private PropagationService propagationService;

    @GetMapping(path = "/add")
    public @ResponseBody User add(@BeanParam User user) {
        return propagationService.save(user);
    }

    @GetMapping(path = "/delete")
    public @ResponseBody Boolean delete(@RequestParam Long id) {
        propagationService.delete(id);
        return true;
    }

    @GetMapping(path = "/update")
    public @ResponseBody User update(@BeanParam User user) {
        return propagationService.save(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return propagationService.findAll();
    }
}