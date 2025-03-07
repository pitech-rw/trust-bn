package pitech.trust.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class CorsConfiguration implements WebMvcConfigurer{

    @Override
    public void addCorsMappings (CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:6066") // Add your front-end's origin here
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    }
