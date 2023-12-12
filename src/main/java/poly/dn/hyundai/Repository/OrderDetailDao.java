package poly.dn.hyundai.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poly.dn.hyundai.Entity.OrderDetail;
@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Long>{
	   @Query("SELECT SUM(o.price)as sum FROM OrderDetail o")
	    public Long countQuantityAndPrice();

	    @Query("SELECT SUM(o.quantity)as sum FROM OrderDetail o")
	    public Long countQuantityAndPrice2();
}
