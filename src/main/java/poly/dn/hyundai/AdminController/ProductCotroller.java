package poly.dn.hyundai.AdminController;

import java.io.IOException;
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

import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Category;
import poly.dn.hyundai.Entity.Product;
import poly.dn.hyundai.Model.ProductModel;
import poly.dn.hyundai.service.CategoryService;
import poly.dn.hyundai.service.ProductService;



@Controller
@RequestMapping("admin/products")
public class ProductCotroller {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	poly.dn.hyundai.service.StorageService storageService;

	@GetMapping("add")
	public String add(Model model) {
		ProductModel dto = new ProductModel();
		List<Category> list = categoryService.findAll();
		model.addAttribute("categories", list);
		dto.setIsEdit(false);
		model.addAttribute("product", dto);
		return "admin/products/addOrEdit";
	}
	public void lisCategory() {
		
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Integer id) {
		Optional<Product> opt = productService.findById(id);
		
		ProductModel dto = new ProductModel();
		if (opt.isPresent()) {
			Product enCategory = opt.get();
			
			List<Category> list = categoryService.findAll();
			model.addAttribute("categories", list);
			
			BeanUtils.copyProperties(enCategory, dto);
			dto.setCategoryId(enCategory.getCategory().getId());
			dto.setIsEdit(true);

			model.addAttribute("product", dto);
			return new ModelAndView("admin/products/addOrEdit", model);
		}
		
		
		model.addAttribute("message", "Sản phẩm không tồn tại");
		return new ModelAndView("forward:/admin/products", model);

	}

	@GetMapping("/assets/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
	    Resource file = storageService.loadAsResource(filename);
	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
	            .body(file);
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id, ModelMap model) throws IOException {
		Optional<Product> otp = productService.findById(id);
		if (otp.isPresent()) {
			if(!StringUtils.isEmpty(otp.get().getImage())){
				storageService.delete(otp.get().getImage());
				storageService.delete(otp.get().getImage2());
				storageService.delete(otp.get().getImage3());
				storageService.delete(otp.get().getImage4());
			}
			productService.delete(otp.get());
			model.addAttribute("message", "Sản phẩm đã bị xóa khỏi danh sách");
		}else {
			model.addAttribute("message","Chưa thể xóa sản phẩm");
		}
		
		return new ModelAndView("forward:/admin/products", model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("product") ProductModel productModel,
			BindingResult result) {
		
		if(result.hasErrors()) {
		    model.addAttribute("errors", result.getFieldError());
			return new ModelAndView("admin/products/addOrEdit");
		}
		Product entity = new Product();
		
		BeanUtils.copyProperties(productModel, entity);
		
		Category category = new Category();
		
		category.setId(productModel.getCategoryId());
		
		entity.setCategory(category);
	

		if (!productModel.getImageFile4().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			entity.setImage4(storageService.getStoredFileName(productModel.getImageFile4(), uuString));
			storageService.store(productModel.getImageFile4(), entity.getImage4());
		}

		if (!productModel.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			entity.setImage(storageService.getStoredFileName(productModel.getImageFile(), uuString));
			storageService.store(productModel.getImageFile(), entity.getImage());
			
		}

		if (!productModel.getImageFile2().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			entity.setImage2(storageService.getStoredFileName(productModel.getImageFile2(), uuString));
			storageService.store(productModel.getImageFile2(), entity.getImage2());
			
		}

		if (!productModel.getImageFile3().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			
			
			entity.setImage3(storageService.getStoredFileName(productModel.getImageFile3(), uuString));
			storageService.store(productModel.getImageFile3(), entity.getImage3());
			
			
		}

		productService.save(entity);
		model.addAttribute("message", "Đã lưu thông tin sản phẩm");

		return new ModelAndView("forward:/admin/products", model);
	}
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Product> list = productService.findAll();
		modelMap.addAttribute("products", list);
		return "admin/products/list";
	}
	
	
	@GetMapping("search")
	public String search(ModelMap map, @RequestParam(name = "name", required = false) String name) {
		List<Product> list = null;
		if (StringUtils.hasText(name)) {
			list = productService.findByNameContaining(name);
		} else {
			list = productService.findAll();
		}
		map.addAttribute("products", list);
		return "admin/products/search";
	}

	@GetMapping("searchpaginated")
	public String search(ModelMap map, @RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		List<Product> list = productService.findAll();
		map.addAttribute("products", list);
		int currentPage = page.orElse(1);
		int pageSize = 3;
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("name"));
		Page<Product> rePage = null;

		if (StringUtils.hasText(name)) {
			rePage = productService.findByNameContaining(name, pageable);
			map.addAttribute("name", name);
		} else {
			rePage = productService.findAll(pageable);
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
		map.addAttribute("productPage", rePage);
		return "admin/products/searchpaginated";
	}

}
