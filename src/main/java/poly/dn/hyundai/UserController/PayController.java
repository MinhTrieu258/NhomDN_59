package poly.dn.hyundai.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {

    @GetMapping("ThanhToan")
    public String thanhtoan(){

        return "user/order/thanhtoan";
    }
}
