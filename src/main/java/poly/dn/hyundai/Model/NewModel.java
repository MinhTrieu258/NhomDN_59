package poly.dn.hyundai.Model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewModel implements Serializable {
	private Long id;
	private String username;
	
	private Boolean isEdit = false;
}
