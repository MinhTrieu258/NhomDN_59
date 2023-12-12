package poly.dn.hyundai.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="comments")
public class Comment implements Serializable {
	

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cmtId;

	@Column(nullable = false, columnDefinition = "nvarchar(MAX)")
  	private String  cmtDescription;

	@Column( columnDefinition = "nvarchar(MAX)")
	private String  status;
	@Temporal(TemporalType.DATE)
	@Column(name = "CreatedateComent")
	Date createDate = new Date();

	@ManyToOne
	@JoinColumn(name = "username")
	Account account;

	
	

}