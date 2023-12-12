package poly.dn.hyundai.AdminController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.service.AccountService;

@Controller
@RequestMapping("admin/accounts")
public class AccountAdminController {
	
	@Autowired
	AccountService customerService;

	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Account> list = customerService.findAll();
	
		modelMap.addAttribute("customers",list);
		return "admin/accounts/list";
	}

	@GetMapping("/security/login/success")
	public String showUsername(ModelMap map) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username);
        map.addAttribute("username", username);
        return "admin/main";
	}
	
	
	@GetMapping("searchpaginated")
	public String search(ModelMap map, @RequestParam(name = "username", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		List<Account> list = customerService.findAll();
		map.addAttribute("products", list);
		int currentPage = page.orElse(1);
		int pageSize = 3;
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("username"));
		Page<Account> rePage = null;

		if (StringUtils.hasText(name)) {
			rePage = customerService.findByFullname(name, pageable);
			map.addAttribute("username", name);
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
		return "admin/accounts/searchpaginated";
	}


}
