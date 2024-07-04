package Customer.src.main.com.retailStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@EnableAutoConfiguration
//@EnableWebMvc
//@CrossOrigin("*")
//@ComponentScan("com.example.retailStore")
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
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
