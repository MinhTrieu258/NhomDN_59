package poly.dn.hyundai.Model;



import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel implements Serializable{
	private Long cmtId;
	
	private String username;
	@NotEmpty(message = "Vui lòng không được để trống")
	private String  status = "đã duyệt";
	@NotNull(message = "Ngày không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	@NotEmpty(message = "Vui lòng không được để trống")
	private String cmtDescription;
	
	public CommentModel(String account, @NotEmpty(message = "Vui lòng không được để trống") String cmtDescription) {
		super();
		this.username = account;
		this.cmtDescription = cmtDescription;
	}

	private Boolean isEdit= false;

	
}
