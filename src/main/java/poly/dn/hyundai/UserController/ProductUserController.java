package poly.dn.hyundai.UserController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dn.hyundai.Entity.Product;
import poly.dn.hyundai.service.ProductService;
@Controller
public class ProductUserController {
    @Autowired
	ProductService productService;


	@GetMapping("/product/list")
public String showlogin(Model model, @RequestParam("cid") Optional<String> cid) {
    List<Product> list;
    
    if (cid.isPresent()) {
            list = productService.findByCategoryId(cid.get());
    } else {
        list = productService.findAll();
    }
    
    model.addAttribute("items", list);
    return "product/list";
}


	@RequestMapping("/product/detail/{id}")
	public String details(@PathVariable("id") Integer id, Model model) {
		Product product = productService.findById(id).get();

		model.addAttribute("product", product);
		return "product/detail";
	}


	@RequestMapping("/product/search")
	public String searchUnitPrice(ModelMap model, 
	    @RequestParam(name="min", required=false)  Double min, 
	    
	    @RequestParam(name="max", required=false)  Double max
	    ) {

	  

	    List<Product> cars;
	    if (min == null || max == null) {
	        cars = productService.findAll();
	    } else {
	        cars = productService.findByPriceBetween(min, max);
	    }

	    System.out.println(min);
	    System.out.println(max);
	    model.addAttribute("listfind", cars);
	    return "product/searchProduct";
	}
	
}
