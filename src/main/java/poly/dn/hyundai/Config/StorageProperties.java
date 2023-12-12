package poly.dn.hyundai.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("storage")
@Data
public class StorageProperties {
	private String location = "src/main/resources/static/assets/images";

	
}

