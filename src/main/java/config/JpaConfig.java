package config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//We just want to be explicit, so we're telling spring where to find repository.
@EnableJpaRepositories(basePackages = {"com.example.demo.repository"})
@EntityScan("com.example.demo.model")
@Configuration
public class JpaConfig {

}