package poly.dn.hyundai.AdminController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.Category;
import poly.dn.hyundai.Entity.Order;
import poly.dn.hyundai.Model.OrderModel;
import poly.dn.hyundai.service.AccountService;
import poly.dn.hyundai.service.OrderAdminService;



@Controller
@RequestMapping("admin/orders")

public class OrderAdminController {
	@Autowired
	AccountService customerService;
	
	@Autowired
	OrderAdminService orderService;
	@GetMapping("add")
	public String add(Model model) {
		OrderModel dto= new OrderModel();
		Date date = new Date();
		dto.setCreateDate(date);
		List<Account> list = customerService.findAll();
		model.addAttribute("customers", list);
		dto.setIsEdit(false);
		model.addAttribute("order", dto);
		return "admin/orders/addOrEdit";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") Long orderId) {
		Optional<Order> opt = orderService.findById(orderId);
		
		OrderModel dto = new OrderModel();
		if(opt.isPresent()) {
			Order enCategory = opt.get();
			
			List<Account> list = customerService.findAll();
			model.addAttribute("customers", list);
			
			Date date = new Date();
			dto.setCreateDate(date);
			
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setAccount(enCategory.getAccount().getUsername());
			
			dto.setIsEdit(true);
	
			model.addAttribute("order",dto);
			return new ModelAndView("admin/orders/addOrEdit",model);
		}
		model.addAttribute("message","Đơn hàng không tồn tại");
		return new ModelAndView( "forward:/admin/orders",model);
	
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("orderId")Long orderId,ModelMap model) {
		orderService.deleteById(orderId);
		
		model.addAttribute("message","Đã xóa đơn hàng");
		
		return new ModelAndView("forward:/admin/orders/search",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model 
			,@Valid @ModelAttribute("order") OrderModel orderModel ,BindingResult result) {
		
		
		if(result.hasErrors()) {
		    model.addAttribute("errors", result.getFieldError());
			return new ModelAndView("admin/orders/addOrEdit");
		}
		Order entity = new Order();
		
		BeanUtils.copyProperties(orderModel, entity);
		
		
		Account customer = new Account();
		customer.setUsername(orderModel.getAccount());
		entity.setAccount(customer);
		
		Date date = new Date();
		entity.setCreateDate(date);
		
		
		
		orderService.save(entity);
		
		model.addAttribute("message","Đã lưu đơn hàng");
		
		return new ModelAndView("forward:/admin/orders",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Order> list = orderService.findAll();
		modelMap.addAttribute("orders",list);
		return "admin/orders/list";
	}

	
	@GetMapping("search")
	public String search(ModelMap map,@RequestParam(name="username",required=false) String username) {
		List<Order> list = null;
		if(username == null) {
			list = orderService.findAll();
		}else {
			list = orderService.findByUsername(username);
		}
		map.addAttribute("orders",list);
		return "admin/orders/search";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap map,@RequestParam(name="username",required=false) String name,
			@RequestParam("page") Optional<Integer> page,@RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize = 5;
		Pageable pageable = PageRequest.of(currentPage-1,pageSize,Sort.by("id"));
		Page<Order> rePage=null;
		
		if(StringUtils.hasText(name)) {
			rePage = orderService.findByUsername(name,pageable);
			map.addAttribute("username",name);
		}else {
			rePage = orderService.findAll(pageable);
		}
		int totalPages = rePage.getTotalPages();
		if(totalPages > 0) {
			int star = Math.max(1, currentPage-2);
			int end = Math.min(currentPage + 2, totalPages);
			if(totalPages > 5) {
				if(end==totalPages) star = end - 5;
				else if(star == 1) end = star + 5;
			}
			
			List<Integer> pageNumber  = IntStream.rangeClosed(star, end).boxed().collect(Collectors.toList());
			map.addAttribute("pageNumbers",pageNumber);
		}
		
		
		map.addAttribute("orderPage",rePage);
		return "admin/orders/searchpaginated";
	}
}
