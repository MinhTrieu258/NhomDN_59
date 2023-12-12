package poly.dn.hyundai.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.dn.hyundai.Entity.Role;
import poly.dn.hyundai.service.RoleService;

@CrossOrigin("*")
@RestController
public class RoleRestController {
    
	@Autowired
	RoleService roleService;
	
	@GetMapping("/rest/roles")
	public List<Role> getAll(){
		return roleService.findAll();
	}
}