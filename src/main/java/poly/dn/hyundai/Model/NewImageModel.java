package poly.dn.hyundai.Model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewImageModel implements Serializable {
   private Long id;
    private Long news_id;
    @NotEmpty(message = "Không được để trống tên loại xe")
    private String titles;
    @NotEmpty(message = "Không được để trống tên loại xe")
    private String contents;
    private String image;
	private MultipartFile imageFile;
	@NotNull(message = "Ngày không được để trống")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    private Boolean isEdit = false;

}