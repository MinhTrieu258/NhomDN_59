package poly.dn.hyundai.Repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.dn.hyundai.Entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
     @Query("Select p from Product p where p.category.id = ?1")
	List<Product> findByCategoryId(String id);

    Page<Product> findByNameContaining(String name, Pageable pageable);

    List<Product> findByNameContaining(String name);
    
    
    @Query("SELECT p FROM  Product  p WHERE p.price >= ?1 and p.price <= ?2")
    List<Product> findByPriceBetween(double minPrice, double maxPrice );
}
