package poly.dn.hyundai.AdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dn.hyundai.Entity.OrderDetail;
import poly.dn.hyundai.Model.DashboardModel;
import poly.dn.hyundai.service.OrderAdminService;
import poly.dn.hyundai.service.OrderDetailAdminService;

@Controller
@RequestMapping("admin/baocao")
public class DashboardController {
	@Autowired
	OrderAdminService orderService;
	
	
	@Autowired
	OrderDetailAdminService orderDetailAdminService;
	
	@RequestMapping("")
	public String list1(ModelMap modelMap) {
		Long total = orderService.countTotalOrder();
		modelMap.addAttribute("countTotalOrder",total);
		Long total4 = orderService.countTotalUserByProduct();
		modelMap.addAttribute("countTotalUserByProduct",total4);
		
		Long total2 = orderDetailAdminService.countTotalQuantity();
		modelMap.addAttribute("countTotalQuantity",total2);
		Long tota3 = orderDetailAdminService.countTotalPrice();
		modelMap.addAttribute("countTotalPrice",tota3);
		
		
		
		return "admin/baocao/index";
	}
	
	@RequestMapping("2")
	public String baocao2(ModelMap map){
		List<DashboardModel> list = orderDetailAdminService.listProductSell();
		map.addAttribute("list", list);
		return "admin/baocao/index2";
	}
}
