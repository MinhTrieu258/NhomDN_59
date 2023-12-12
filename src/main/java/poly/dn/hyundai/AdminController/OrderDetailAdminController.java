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

import com.nimbusds.jose.util.IntegerUtils;

import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Order;
import poly.dn.hyundai.Entity.OrderDetail;
import poly.dn.hyundai.Entity.Product;
import poly.dn.hyundai.Model.OrderDetailModel;
import poly.dn.hyundai.service.OrderAdminService;
import poly.dn.hyundai.service.OrderDetailAdminService;
import poly.dn.hyundai.service.ProductService;


@Controller
@RequestMapping("admin/orderDetails")

public class OrderDetailAdminController {
	@Autowired
	ProductService carService;
	
	@Autowired
	OrderAdminService orderService;
	
	@Autowired
	OrderDetailAdminService orderDetailService;
	@GetMapping("add")
	public String add(Model model) {
		OrderDetailModel dto = new OrderDetailModel();
		List<Product> listProduct = carService.findAll();
		List<Order> listOrder = orderService.findAll();
		model.addAttribute("products", listProduct);
		model.addAttribute("orders", listOrder);
		dto.setIsEdit(false);
		model.addAttribute("orderDetail", dto);
		return "admin/orderDetails/addOrEdit";
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,@PathVariable("id") Long orderDetailId) {
		Optional<OrderDetail> opt = orderDetailService.findById(orderDetailId);
		
		List<Product> listProduct = carService.findAll();
		List<Order> listOrder = orderService.findAll();
		model.addAttribute("products", listProduct);
		model.addAttribute("orders", listOrder);
		OrderDetailModel dto = new OrderDetailModel();
		if(opt.isPresent()) {
			OrderDetail enCategory = opt.get();
					
			BeanUtils.copyProperties(enCategory, dto);
			
			dto.setCarId(enCategory.getProduct().getId());
			dto.setOrderId(enCategory.getOrder().getId());		
			dto.setIsEdit(true);
			System.out.println(orderDetailId);
			model.addAttribute("orderDetail",dto);
			return new ModelAndView("admin/orderDetails/addOrEdit",model);
		}
		model.addAttribute("message","Không tìn thấy thông tin chi tiết đơn hàng");
		return new ModelAndView( "forward:/admin/orderDetails",model);
	
	}
	
	@GetMapping("delete/{orderDetailId}")
	public ModelAndView delete(@PathVariable("orderDetailId")Long orderId,ModelMap model) {
		orderDetailService.deleteById(orderId);
		
		model.addAttribute("message","Đã xóa đơn hàng ");
		
		return new ModelAndView("forward:/admin/orderDetails",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model 
			,@Valid @ModelAttribute("orderDetail") OrderDetailModel orderModel ,BindingResult result) {
		
		OrderDetail entity = new OrderDetail();
		
		BeanUtils.copyProperties(orderModel, entity);
		
	
		
		Product product = new Product();
		product.setId(orderModel.getCarId());
		entity.setProduct(product);
		
		Order order = new Order();
		order.setId(orderModel.getOrderId());
		entity.setOrder(order);	
		
	
		
		orderDetailService.save(entity);
		
		model.addAttribute("message","Đã lưu đơn hàng");
		
		return new ModelAndView("forward:/admin/orderDetails",model) ;
	}
	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<OrderDetail> list = orderDetailService.findAll();
		modelMap.addAttribute("orderDetails",list);
		return "admin/orderDetails/list";
	}

	@GetMapping("view/{id}")
	public ModelAndView view(ModelMap model,@PathVariable("id") Long orderDetailId) {
		Optional<OrderDetail> opt = orderDetailService.findById(orderDetailId);
		
		List<Product> listProduct = carService.findAll();
		List<Order> listOrder = orderService.findAll();
		model.addAttribute("products", listProduct);
		model.addAttribute("orders", listOrder);
		OrderDetailModel dto = new OrderDetailModel();
		
			OrderDetail enCategory = opt.get();
					
			BeanUtils.copyProperties(enCategory, dto);

			dto.setCarId(enCategory.getProduct().getId());
			dto.setOrderId(enCategory.getOrder().getId());			
			model.addAttribute("orderDetail",dto);
			return new ModelAndView("admin/orderDetails/view",model);
	
	}
	@GetMapping("searchpaginated")
	public String search(ModelMap map, @RequestParam(name = "quantity", required = false) Integer name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
	
		int currentPage = page.orElse(1);
		int pageSize = 5;
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("price"));
		Page<OrderDetail> rePage = null;

		if (name == null) {
			
			rePage = orderDetailService.findAll(pageable);
			
		} else {
			rePage = orderDetailService.findByOrderDetail(name, pageable);
			map.addAttribute("quantity", name);
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
		map.addAttribute("orderDetailPage", rePage);
		return "admin/orderDetails/searchpaginated";
	}
}
