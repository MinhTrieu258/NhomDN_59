package poly.dn.hyundai.Model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class DashboardModel  {
	 public DashboardModel() {
		super();
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	private Integer productId;
	 private Integer quantity;
	 private BigDecimal price;
	
	 
	 public DashboardModel(Integer productId, Integer quantity, BigDecimal price) {
		    this.productId = productId;
		    this.quantity = quantity;
		    this.price = price;
		}

}
