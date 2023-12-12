package poly.dn.hyundai.UserController;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import poly.dn.hyundai.Entity.Comment;
import poly.dn.hyundai.Entity.New;
import poly.dn.hyundai.Model.CommentModel;
import poly.dn.hyundai.service.CommentService;
import poly.dn.hyundai.service.NewService;

@Controller
    @RequestMapping("/binhluan")
public class CommentUserController {
      @Autowired
    CommentService commentService;
    @Autowired
     NewService newsService;
    @RequestMapping("add")
    public  String list(Model model){
        model.addAttribute("binhluan", new CommentModel());
        return "comments/addOrEdit";
    }
     
    @RequestMapping("listNew")
    public String listNew(Model model){
          List<New> newsList = newsService.findAll(); // Lấy danh sách tin tức từ service, bao gồm danh sách hình ảnh.

        model.addAttribute("newsList", newsList); // Truy
        return "common/new1";
    }
     @PostMapping("/saveComment")
    public ModelAndView save(ModelMap modelMap, @Valid  @ModelAttribute("binhluan")CommentModel customerModel, BindingResult result){
  if (result.hasErrors()){
      modelMap.addAttribute("error", "Bình luận thất bại");
      return new ModelAndView( "comments/addOrEdit",modelMap);
  }else {
      Comment entity = new Comment();
      BeanUtils.copyProperties(customerModel, entity);

      commentService.save(entity);
      modelMap.addAttribute("message", "Bình luận thành công");


      return new ModelAndView("forward:/binhluan/add", modelMap);
  }
    }
}
