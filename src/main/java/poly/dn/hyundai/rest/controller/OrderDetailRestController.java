package poly.dn.hyundai.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.dn.hyundai.Entity.OrderDetail;
import poly.dn.hyundai.service.OrderDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderDetails")
public class OrderDetailRestController {
    @Autowired 
	 OrderDetailService orderService;



	 @GetMapping
	 public List<OrderDetail> getAll(){
		 return orderService.findAll();
	 }
	 
	
}