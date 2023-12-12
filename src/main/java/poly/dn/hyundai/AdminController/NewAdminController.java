package poly.dn.hyundai.AdminController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.New;
import poly.dn.hyundai.Model.NewModel;
import poly.dn.hyundai.service.AccountService;
import poly.dn.hyundai.service.NewService;

@Controller
@RequestMapping("admin/news")
public class NewAdminController {
	@Autowired
	NewService newService;
	@Autowired
	AccountService customerService;
	
	
	@GetMapping("add")
	public String add(Model model) {
		NewModel dto = new NewModel();
		
		
		List<Account> list = customerService.findAll();
		model.addAttribute("customers", list);
	
		dto.setIsEdit(false);
		model.addAttribute("news", dto);
		
		
		
		return "admin/news/addOrEdit";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") Long id) {
		
		Optional<New> opt = newService.findById(id);
		List<Account> list = customerService.findAll();
		model.addAttribute("customers", list);
	
		NewModel dto = new NewModel();
		if(opt.isPresent()) {
			
			New enCategory = opt.get();
			
			dto.setUsername(enCategory.getAccount().getUsername());
			BeanUtils.copyProperties(enCategory, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("new",dto);
			return new ModelAndView("admin/news/addOrEdit",model);
		}
		model.addAttribute("message","Tin tức không tồn tại");
		return new ModelAndView( "forward:/admin/news");
	
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id")Long Id,ModelMap model) {
		
		newService.deleteById(Id);
		
		model.addAttribute("message","Đã xóa tin tức");
		
		return new ModelAndView("forward:/admin/news",model);
	}
	

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Validated @ModelAttribute("news") NewModel newModel,BindingResult result) {
		
		New entity = new New();
		
		BeanUtils.copyProperties(newModel, entity);
		
		
		
		
		Account customer = new Account();
		customer.setUsername(newModel.getUsername());
		
		entity.setAccount(customer);
		
		newService.save(entity);
		model.addAttribute("message","Đã lưu tin tức");
		
		return new ModelAndView("forward:/admin/news",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<New> list = newService.findAll();
		modelMap.addAttribute("news",list);
		return "admin/news/list";
	}
}
