package Product.src.main.com.retailStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableAutoConfiguration
//@EnableWebMvc
//@CrossOrigin("*")
//@ComponentScan("com.example.retailStore")
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigure(){
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE").allowedOrigins("*")
//						.allowedHeaders("*");
//			}
//		};
//	}

}
