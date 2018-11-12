package propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import propagation.entity.User;

@Controller
@RequestMapping(path = "/propagation")
public class PropagationController {

    @Autowired
    private PropagationService1 propagationService1;

    @PostMapping(path = "/users")
    public @ResponseBody Boolean addUser(@RequestBody User user) {
        return propagationService1.addUser(user);
    }

}