package poly.dn.hyundai.Model;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel implements Serializable {
	
	@NotEmpty(message = "Không được để trống mã loại xe")
	private String id;
	
	@NotEmpty(message = "Không được để trống tên loại xe")
	
	private String name;
	private Boolean isEdit = false;
}