package poly.dn.hyundai.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {
    
    @GetMapping("/home")
    public String home(){
        return "home/index";
    }
}
