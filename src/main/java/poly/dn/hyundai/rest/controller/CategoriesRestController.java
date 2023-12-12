package poly.dn.hyundai.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.dn.hyundai.Entity.Category;
import poly.dn.hyundai.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoriesRestController {

	 @Autowired 
	 CategoryService categoryService;
	 
	 @GetMapping()
	 public List<Category> getAll() {
		 return categoryService.findAll();
	 }
	 
	  @PostMapping
	    public Category create(@RequestBody Category cate) {
	    	return categoryService.save(cate);
	    }
	    @PutMapping("{id}")
		 public Category update(@PathVariable("id") String username, @RequestBody Category cate) {
			 return categoryService.update(cate);
		 }
	    
	    @DeleteMapping("{id}")
		 public void delete(@PathVariable("id") String id) {
	    	categoryService.deleteById(id);
		 }
}