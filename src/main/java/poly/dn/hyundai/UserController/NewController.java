package poly.dn.hyundai.UserController;

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
import poly.dn.hyundai.service.CommentService;
import poly.dn.hyundai.service.NewService;

@Controller
    @RequestMapping("/user/news")

public class NewController {
     @Autowired
    CommentService commentService;
    @Autowired
     NewService newsService; // Đây là một service để truy xuất dữ liệu tin tức.
    @RequestMapping("")
    public String listNews(Model model) {
      List<New> newsList = newsService.findAll(); // Lấy danh sách tin tức từ service, bao gồm danh sách hình ảnh.

        model.addAttribute("newsList", newsList); // Truyền danh sách tin tức đến trang HTML.
   List<Comment> list = commentService.findAll(); // Lấy danh sách tin tức từ service, bao gồm danh sách hình ảnh.

        model.addAttribute("listComment", list); // Truyền danh sách tin tức đến trang HTML.

 model.addAttribute("comment", new CommentModel());
        return "common/new1"; // Trả về tên trang HTML để hiển thị danh sách tin tức.
    }
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

    	        return new ModelAndView("forward:/user/news", model);
    	    } else {
    	        // Xử lý khi không có thông tin authentication
    	        // ...

    	        return new ModelAndView("forward:/home"); // Ví dụ: chuyển hướng đến trang đăng nhập
    	    }
    }
}
