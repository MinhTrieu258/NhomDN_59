package poly.dn.hyundai.UserController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Model.AccountModel;
import poly.dn.hyundai.service.AccountService;

@Controller
public class SignupController {

    @Autowired
    AccountService customerService;

    @RequestMapping("Signup")
    public  String list(Model model){
        model.addAttribute("customer", new AccountModel());
        return "common/dangky";
    }
    @PostMapping("/save")
    public ModelAndView save(ModelMap modelMap, @Valid  @ModelAttribute("customer")AccountModel customerModel, BindingResult result){
  if (result.hasErrors()){
      modelMap.addAttribute("error", "Đăng ký thất bại");
      return new ModelAndView( "common/dangky",modelMap);
  }else {
      Account entity = new Account();
      BeanUtils.copyProperties(customerModel, entity);

      customerService.save(entity);
      modelMap.addAttribute("message", "Đăng ký thành công");


      return new ModelAndView("forward:/Signup", modelMap);
  }
    }
}