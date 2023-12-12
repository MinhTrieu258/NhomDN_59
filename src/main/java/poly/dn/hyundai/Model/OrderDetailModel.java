package poly.dn.hyundai.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailModel implements Serializable {
	private Long id;
	private Double price;
	private Integer quantity;
	private String status;
	private Long orderId;
	private Integer carId;
	private Boolean isEdit = false;
}	
