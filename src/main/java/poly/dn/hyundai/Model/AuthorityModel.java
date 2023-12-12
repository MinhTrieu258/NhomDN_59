package poly.dn.hyundai.Model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityModel {
	private Integer id;
	private String account;
	private String role;
	private Boolean isEdit = false;
}
