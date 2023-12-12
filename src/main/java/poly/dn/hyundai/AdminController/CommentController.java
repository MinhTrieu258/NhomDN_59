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
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.Comment;
import poly.dn.hyundai.Model.CommentModel;
import poly.dn.hyundai.service.AccountService;
import poly.dn.hyundai.service.CommentService;

@Controller
@RequestMapping("admin/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	@Autowired
	AccountService accountService;
	
	@GetMapping("edit/{cmtId}")
	public ModelAndView edit(ModelMap model,@PathVariable("cmtId") Long cmtId) {
		
		Optional<Comment> opt = commentService.findById(cmtId);
		CommentModel dto = new CommentModel();
		if(opt.isPresent()) {
			
		
			Comment enCategory = opt.get();
			
			BeanUtils.copyProperties(enCategory, dto);
			
			dto.setUsername(enCategory.getAccount().getUsername());
			dto.setIsEdit(true);
			
			model.addAttribute("comment",dto);
			return new ModelAndView("admin/comments/addOrEdit",model);
		}
		model.addAttribute("message","Bài viết không tồn tại");
		return new ModelAndView( "forward:/admin/comments");
	
	}
	
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model
			,@Valid @ModelAttribute("comment") CommentModel commentModel,BindingResult result) {
		if(result.hasErrors()) {
		    model.addAttribute("errors", result.getFieldError());
			return new ModelAndView("admin/comments/addOrEdit");
		}
		Comment entity = new Comment();
		BeanUtils.copyProperties(commentModel, entity);
		
		Account account = new Account();
		account.setUsername(commentModel.getUsername());
		
		entity.setAccount(account);
		commentService.save(entity);
		
		model.addAttribute("message","Đã lưu bài viết");
		
		return new ModelAndView("forward:/admin/comments",model) ;
	}
	

	
	@GetMapping("delete/{cmtId}")
	public ModelAndView delete(@PathVariable("cmtId")Long cmtId,ModelMap model) {
		commentService.deleteById(cmtId);
		
		model.addAttribute("message","Đã xóa bài viết khỏi danh sách");
		
		return new ModelAndView("forward:/admin/comments",model);
	}
	

	
	@RequestMapping("")
	public String list(ModelMap modelMap) {
		List<Comment> list = commentService.findAll();
		modelMap.addAttribute("comments",list);
		return "admin/comments/list";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap map, @RequestParam(name = "fullname", required = false) String name,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize = 5;
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("cmtId"));
		Page<Comment> rePage = null;

		if (StringUtils.hasText(name)) {
			rePage = commentService.pagecomment(name, pageable);
			map.addAttribute("fullname", name);
		} else {
			rePage = commentService.findAll(pageable);
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
		return "admin/comments/searchpaginated";
	}
	
}
