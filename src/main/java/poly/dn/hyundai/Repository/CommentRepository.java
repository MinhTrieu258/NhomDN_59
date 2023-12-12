package poly.dn.hyundai.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.dn.hyundai.Entity.Comment;

public interface CommentRepository  extends JpaRepository<Comment, Long>{
	
	@Query("SELECT c FROM Comment c Where c.account.fullname = ?1")
	Page<Comment> pagecomment(String username,Pageable pageable);
	
}
