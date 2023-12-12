package poly.dn.hyundai.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.NamedNativeQuery;
import poly.dn.hyundai.Entity.OrderDetail;
import poly.dn.hyundai.Model.DashboardModel;



public interface OrderDetailAdminRepository extends JpaRepository<OrderDetail, Long> {
	 @Query("SELECT SUM(o.price)as sum FROM OrderDetail o")
	    public Long countTotalPrice();

	    @Query("SELECT SUM(o.quantity)as sum FROM OrderDetail o")
	    public Long countTotalQuantity();
	    
	  @Query("SELECT o FROM OrderDetail o Where o.quantity= ?1")
	  Page<OrderDetail> findByOrderDetail(Integer quantity, Pageable pageable);
	  
	  @Query("SELECT new poly.dn.hyundai.Model.DashboardModel(p.id, SUM(od.quantity), SUM(od.price)) FROM OrderDetail od JOIN od.product p GROUP BY p.id")
	  List<DashboardModel> listProductSell();
}
