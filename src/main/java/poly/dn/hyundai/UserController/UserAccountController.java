package poly.dn.hyundai.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dn.hyundai.service.AccountService;
import poly.dn.hyundai.service.CustomUserDetails;

@Controller
public class UserAccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("UserAcc")
     public String userProfile(Model model, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("fullname", userDetails.getFullname());
        model.addAttribute("email", userDetails.getEmail());
        model.addAttribute("phone", userDetails.getPhoneNumber());

     model.addAttribute("password", userDetails.getPassword());
            return "common/taikhoan"; // Trả về tên template HTML
       
        }
    

    }