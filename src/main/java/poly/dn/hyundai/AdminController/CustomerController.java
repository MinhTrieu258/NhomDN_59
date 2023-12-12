package poly.dn.hyundai.AdminController;

import java.util.Iterator;
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

import groovyjarjarantlr4.v4.parse.ANTLRParser.sync_return;
import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.Category;
import poly.dn.hyundai.Entity.Product;
import poly.dn.hyundai.Model.AccountModel;
import poly.dn.hyundai.service.AccountService;
import poly.dn.hyundai.service.CategoryService;


@Controller
@RequestMapping("admin/customers")

public class CustomerController {

	@Autowired
	AccountService customerService;
	
	@GetMapping("add")
	public String add(Model model) {
		
		model.addAttribute("customer", new AccountModel());
		return "admin/customers/addOrEdit";
	}
	
	@GetMapping("edit/{username}")
	public ModelAndView edit(ModelMap model,@PathVariable("username") String customerId) {
		
		Optional<Account> opt = customerService.findById(customerId);
		AccountModel dto = new AccountModel();
		if(opt.isPresent()) {
			
			Account enCategory = opt.get();
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("customer",dto);
			return new ModelAndView("admin/customers/addOrEdit",model);
		}
		model.addAttribute("message","Người dùng không tồn tại");
		return new ModelAndView( "forward:/admin/customers");
	
	}
	
	@GetMapping("delete/{username}")
	public ModelAndView delete(@PathVariable("username")String customerId,ModelMap model) {
		customerService.deleteById(customerId);
		
		model.addAttribute("message","Đã xóa người dùng");
		
		return new ModelAndView("forward:/admin/customers",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Valid @ModelAttribute("customer") AccountModel customerModel,BindingResult result) {
		if(result.hasErrors()) {
		    model.addAttribute("errors", result.getFieldError());
			return new ModelAndView("admin/customers/addOrEdit");
		}
		Account entity = new Account();
		BeanUtils.copyProperties(customerModel, entity);
		
		customerService.save(entity);
		
		model.addAttribute("message","Đã lưu người dùng");
		
		return new ModelAndView("forward:/admin/customers",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Account> list = customerService.findAll();
	
		modelMap.addAttribute("customers",list);
		return "admin/customers/list";
	}

	@GetMapping("search")
	public String search(ModelMap map,@RequestParam(name="fullname",required=false) String name) {
		List<Account> list = null;
		if(StringUtils.hasText(name)) {
			list = customerService.findByFullname(name);
		}else {
			list = customerService.findAll();
		}
		map.addAttribute("customers",list);
		return "admin/customers/search";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap map, @RequestParam(name = "fullname", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		List<Account> list = customerService.findAll();
		map.addAttribute("products", list);
		int currentPage = page.orElse(1);
		int pageSize = 3;
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("fullname"));
		Page<Account> rePage = null;

		if (StringUtils.hasText(name)) {
			rePage = customerService.findByFullname(name, pageable);
			map.addAttribute("fullname", name);
		} else {
			rePage = customerService.findAll(pageable);
		}
		int totalPages = rePage.getTotalPages();
		if (totalPages > 0) {
			int star = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2, totalPages);
			if (totalPages > 5) {
				if (end == totalPages)
					star = end - 5;
				else if (star == 1)
					end = star + 5;
			}
			List<Integer> pageNumber = IntStream.rangeClosed(star, end).boxed().collect(Collectors.toList());
			map.addAttribute("pageNumbers", pageNumber);
		}
		map.addAttribute("customerPage", rePage);
		return "admin/customers/searchpaginated";
	}

	

	
	
}
