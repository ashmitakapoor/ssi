package com.redhat.ssi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SSIApplication {

	public static void main(String[] args) {
		SpringApplication.run(SSIApplication.class, args);
    
	}
/*	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}*/
/*	@Autowired
	SSIRepository ssiRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SSIController ssiCT = new SSIController();
		ssiCT.addSSI("ABC", "RS", "pos", "owne", "gh", "bic", 123, "absdghj", "asd1244", "bic", 1234, "adfef","asd1434");
		ssiRepository.save(ssi);
		
	}*/
	
	/*@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        //config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    */
    
    

}