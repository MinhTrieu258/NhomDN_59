package poly.dn.hyundai.Model;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountModel implements Serializable {
	@NotBlank(message = "Tên đăng nhập không được để trống")
	private String username;
	@NotBlank(message = "Họ và tên không được để trống")
	@Pattern(regexp = "^[\\p{L} ]+$", message = "Họ và tên chỉ được chứa chữ cái và khoảng trắng")
	private String fullname;
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không hợp lệ")
	private String email;
	@NotBlank(message = "Số điện thoại không được để trống")
	@Pattern(regexp = "^[0-9]*$", message = "Số điện thoại chỉ được chứa số")
  private String phoneNumber;

	@NotBlank(message = "Mật khẩu không được để trống")
	private String password;
	private Boolean isEdit = false;
	
}