package poly.dn.hyundai.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import poly.dn.hyundai.service.AccountService;
import poly.dn.hyundai.service.OrderAdminService;
import poly.dn.hyundai.service.OrderDetailAdminService;

@Controller
public class HomeAdminController {
	
	@Autowired
	OrderAdminService orderService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	OrderDetailAdminService orderDetailAdminService;
	@RequestMapping({"/","/home/index"})
	public String user(){
		return "redirect:/home";
	}
	  @GetMapping("admin")
	  public String list(ModelMap modelMap) {
		  
		  Long total = orderService.countTotalOrder();
		  modelMap.addAttribute("countTotalOrder",total);
		  
		  Long total2 = orderDetailAdminService.countTotalQuantity();
		  modelMap.addAttribute("countTotalQuantity",total2);
		  
		  
		  Long tota3 = orderDetailAdminService.countTotalPrice();
		  modelMap.addAttribute("countTotalPrice",tota3);
		  
		  
		  Long total4 = accountService.countUser();
		  modelMap.addAttribute("countUser", total4);
		  return "admin/home/index";
	  }
	

}
