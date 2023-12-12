package poly.dn.hyundai.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import poly.dn.hyundai.Entity.Order;

public interface OrderAdminRepository extends JpaRepository<Order, Long>{
	@Query("SELECT o FROM Order o WHERE o.account.fullname=?1")
	List<Order> findByUsername(String username);
	
	
	   @Query("SELECT COUNT(o)as sum FROM Order o")
	    public Long countTotalOrder();
	   
	   @Query("SELECT COUNT(o.account)as sum FROM Order o")
	   public Long countTotalUserByProduct();
	   
	   @Query("SELECT o FROM Order o WHERE o.account.fullname= %?1%")
		Page<Order> findByUsername(String username,Pageable pageable);
	  
	   @Query("SELECT o FROM Order o")
	   Page<Order> findAllOrderPaginated(Pageable pageable );
	   
	   
}
