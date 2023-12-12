package poly.dn.hyundai.Entity;

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
@Table(name = "news_images")
public class NewsImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private New news;

    @Column(nullable = false, columnDefinition = "nvarchar(MAX)")
    private String titles;

    @Column(nullable = false ,name="contnet_text",columnDefinition = "nvarchar(MAX)")
    private String contents;

    @Column(nullable = false , columnDefinition = "nvarchar(255)")
    private String image;

    @Temporal(TemporalType.DATE)
    private Date createdDate;
}
