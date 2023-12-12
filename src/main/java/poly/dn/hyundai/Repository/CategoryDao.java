package poly.dn.hyundai.Repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import poly.dn.hyundai.Entity.Category;

public interface CategoryDao extends JpaRepository<Category, String> {
 List<Category> findByNameContaining(String name);
	Page<Category> findByNameContaining(String name,Pageable pageable);
}
