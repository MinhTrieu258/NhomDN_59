package poly.dn.hyundai.Model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel implements Serializable {
	private Integer id;
	private String categoryId;
	@NotNull(message = "Vui lòng không để trống")
	@Digits(integer = 10, fraction = 2, message = "Vui lòng nhập một số nguyên hoặc số thực hợp lệ")
	Integer manufacturingYear;
	@NotEmpty(message = "Vui lòng không để trống")
	String driveSystem;
	@NotNull(message = "Vui lòng không để trống")
	@Digits(integer = 10, fraction = 2, message = "Vui lòng nhập một số nguyên hoặc số thực hợp lệ")
	Double engineCapacity;
	@NotEmpty(message = "Vui lòng không được để trống")
	String engine;
	@NotEmpty(message = "Vui lòng không được để trống")
	String transmission;
	@NotEmpty(message = "Vui lòng không được để trống")
	private String name;
	@NotNull(message = "Vui lòng không để trống")
	@Digits(integer = 10, fraction = 2, message = "Vui lòng nhập một số nguyên hoặc số thực hợp lệ")
	private Double price;
	private String image;
	private String image2;
	private String image3;
	private String image4;

	private String description;
	private MultipartFile imageFile;
	private MultipartFile imageFile2;
	private MultipartFile imageFile3;
	private MultipartFile imageFile4;
	private Boolean isEdit = false;
}