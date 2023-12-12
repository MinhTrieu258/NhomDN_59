package poly.dn.hyundai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import poly.dn.hyundai.Config.StorageProperties;
import poly.dn.hyundai.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class HyundaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyundaiApplication.class, args);
	}
@Bean
	CommandLineRunner init(StorageService service){
		return (args->{
              service.init();
		});
	}
}
