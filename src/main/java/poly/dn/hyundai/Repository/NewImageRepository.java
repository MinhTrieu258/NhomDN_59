package poly.dn.hyundai.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.dn.hyundai.Entity.NewsImage;

public interface NewImageRepository extends JpaRepository<NewsImage, Long> {
	
	@Query("SELECT n From NewsImage n Where n.id = ?1")
	Page<NewsImage> findByTitle(Integer id,Pageable pageable);
}
