package poly.dn.hyundai.AdminController;

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

import poly.dn.hyundai.Entity.Category;
import poly.dn.hyundai.Model.CategoryModel;
import poly.dn.hyundai.service.CategoryService;



@Controller
@RequestMapping("admin/categories")

public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new CategoryModel());
		return "admin/categories/addOrEdit";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") String id) {
		
		Optional<Category> opt = categoryService.findById(id);
		
		CategoryModel dto = new CategoryModel();
		
		if(opt.isPresent()) {
			
			Category enCategory = opt.get();
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("category",dto);
			return new ModelAndView("admin/categories/addOrEdit",model);
		}
		model.addAttribute("message","Loại xe không tồn tại");
		return new ModelAndView( "forward:/admin/categories");
	
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id,ModelMap model) {
		categoryService.deleteById(id);
		
		model.addAttribute("message","Đã xóa loại xe");
		
		return new ModelAndView("forward:/admin/categories/search",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Validated @ModelAttribute("category") CategoryModel categorymodel,BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/categories/addOrEdit");
		}
		Category entity = new Category();
		BeanUtils.copyProperties(categorymodel, entity);
		
		categoryService.save(entity);
		
		model.addAttribute("message","Đã lưu thành công");
		
		return new ModelAndView("forward:/admin/categories",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Category> list = categoryService.findAll();
		modelMap.addAttribute("categories",list);
		return "admin/categories/list";
	}
	
	@GetMapping("search")
	public String search(ModelMap map,@RequestParam(name="name",required=false) String name) {
		List<Category> list = null;
		if(StringUtils.hasText(name)) {
			list = categoryService.findByNameContaining(name);
		}else {
			list = categoryService.findAll();
		}
		map.addAttribute("categories",list);
		return "admin/categories/search";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap map,@RequestParam(name="name",required=false) String name,
			@RequestParam("page") Optional<Integer> page,@RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize = 5;
		Pageable pageable = PageRequest.of(currentPage-1,pageSize,Sort.by("name"));
		Page<Category> rePage=null;
		
		if(StringUtils.hasText(name)) {
			rePage = categoryService.findByNameContaining(name,pageable);
			map.addAttribute("name",name);
		}else {
			rePage = categoryService.findAll(pageable);
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
		
		
		map.addAttribute("categoryPage",rePage);
		return "admin/categories/searchpaginated";
	}
	
}
