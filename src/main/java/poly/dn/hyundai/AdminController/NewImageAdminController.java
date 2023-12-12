package poly.dn.hyundai.AdminController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.New;
import poly.dn.hyundai.Entity.NewsImage;
import poly.dn.hyundai.Model.NewImageModel;
import poly.dn.hyundai.service.NewImageService;
import poly.dn.hyundai.service.NewService;
import poly.dn.hyundai.service.StorageService;

@Controller
@RequestMapping("admin/newImages")

public class NewImageAdminController {
	
	@Autowired
	NewImageService newService;
	
	@Autowired
	NewService newsService;
	
	@Autowired
	StorageService storageService;

	
	@GetMapping("add")
	public String add(Model model) {
		NewImageModel dto = new NewImageModel();
		List<New> list = newsService.findAll();
		model.addAttribute("news", list);
		dto.setIsEdit(false);
		model.addAttribute("newImage", dto);
		
		
		
		return "admin/newImages/addOrEdit";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") Long id) {
		
		Optional<NewsImage> opt =newService.findById(id);
		
		NewImageModel dto = new NewImageModel();
		
		if(opt.isPresent()) {


			NewsImage enCategory = opt.get();
			
			BeanUtils.copyProperties(enCategory, dto);
			Date date = new Date();
			dto.setCreatedDate(date);
			dto.setNews_id(enCategory.getNews().getId());		
			dto.setIsEdit(true);
			
			model.addAttribute("newImage",dto);
			return new ModelAndView("admin/newImages/addOrEdit",model);
		}
		model.addAttribute("message","Bản tin không tồn tại");
		return new ModelAndView( "forward:/admin/newImages",model);
	
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id")Long Id,ModelMap model) {
		newService.deleteById(Id);
		
		model.addAttribute("message","Đã xóa bản tin");
		
		return new ModelAndView("forward:/admin/newImages",model);
	}
	
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Validated @ModelAttribute("newImage") NewImageModel newModel,BindingResult result) {
		if(result.hasErrors()) {
		    model.addAttribute("errors", result.getFieldError());
			return new ModelAndView("admin/newImages/addOrEdit");
		}
		NewsImage entity = new NewsImage();
		BeanUtils.copyProperties(newModel, entity);
		
		
		Date date = new Date();
		entity.setCreatedDate(date);
		New news = new New();
		news.setId(newModel.getNews_id());
		entity.setNews(news);
		

		if (!newModel.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			entity.setImage(storageService.getStoredFileName(newModel.getImageFile(), uuString));
			storageService.store(newModel.getImageFile(), entity.getImage());
		}

		
		newService.save(entity);
		model.addAttribute("message","Đã lưu bản tin");
		
		return new ModelAndView("forward:/admin/newImages",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<NewsImage> list = newService.findAll();
		modelMap.addAttribute("newImages",list);
		return "admin/newImages/list";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap map, @RequestParam(name = "id", required = false) Integer id,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize = 3;
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("id"));
		Page<NewsImage> rePage = null;

		if (id == null) {
			
			rePage = newService.findAll(pageable);
			
		} else {
			rePage = newService.findByTitle(id, pageable);
			map.addAttribute("id", id);
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
		map.addAttribute("categoryPage", rePage);
		return "admin/newImages/searchpaginated";
	}
}
