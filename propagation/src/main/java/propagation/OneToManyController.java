package propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/onetomany")
public class OneToManyController {

    @Autowired
    private OneToManyService oneToManyService;

    @GetMapping(path = "/add")
    public @ResponseBody Boolean addDepartment() {
        return oneToManyService.addDepartment();
    }

}