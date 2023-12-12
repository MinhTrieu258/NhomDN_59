package poly.dn.hyundai.Model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel implements Serializable {
	private Long id;
	
	@NotBlank(message = "Ngày không được để trống")
	private String address;
	
	@NotNull(message = "Ngày không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	private String account;
	
	private String paymentMethod;
	
	private Boolean isEdit = false;
}
