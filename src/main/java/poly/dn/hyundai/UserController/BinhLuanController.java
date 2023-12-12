package poly.dn.hyundai.UserController;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.Comment;
import poly.dn.hyundai.Entity.New;
import poly.dn.hyundai.Model.CommentModel;
import poly.dn.hyundai.service.AccountService;
import poly.dn.hyundai.service.CommentService;
import poly.dn.hyundai.service.NewService;

@Controller
@RequestMapping("user/comments")
public class BinhLuanController {
     @Autowired
    private CommentService commentService;
     
      @Autowired
     NewService newsService;
 @Autowired
 AccountService accountService;
    @RequestMapping("")
    public String showComments(Model model, Principal principal) {
    
            List<New> newsList = newsService.findAll(); // Lấy danh sách tin tức từ service, bao gồm danh sách hình ảnh.

            model.addAttribute("newsList", newsList);
    	 List<Comment> commentList = commentService.findAll();
         model.addAttribute("listComment", commentList);
         model.addAttribute("comment", new CommentModel()); // Thêm một đối tượng CommentModel mới cho form

         return "common/new1";
    }

    /*
 @PostMapping("/comments/add")
    public String addComment(@RequestParam String commentDescription, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            commentService.addComment(username, commentDescription);
        }
        // Chuyển hướng "redirect" về trang hiển thị bình luận sau khi thêm bình luận
        return "redirect:/user/comments";
    }
    */
    
    
  
    @Transactional
    @PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model 
			,@Valid @ModelAttribute("comment") CommentModel commentModel ,BindingResult result,Authentication authentication) {
		
	
    	 if (authentication != null && authentication.isAuthenticated()) {
    	        String username = authentication.getName(); // Lấy username từ principal

    	        Comment entity = new Comment();
    	        BeanUtils.copyProperties(commentModel, entity);

    	        Account customer = new Account();
    	        customer.setUsername(username); // Sử dụng username từ principal
    	        entity.setAccount(customer);

    	        Date date = new Date();
    	        entity.setCreateDate(date);

    	        commentService.save(entity);

    	        model.addAttribute("message", "Đã lưu đơn hàng");

    	        return new ModelAndView("forward:/user/comments", model);
    	    } else {
    	        // Xử lý khi không có thông tin authentication
    	        // ...

    	        return new ModelAndView("redirect:/security/login/form"); // Ví dụ: chuyển hướng đến trang đăng nhập
    	    }
    }
	
}
