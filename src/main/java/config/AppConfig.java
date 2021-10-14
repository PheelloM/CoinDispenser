package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//We just want to be explicit, so we're telling spring where to find beans.
@Configuration
@ComponentScan(basePackages = {"com.example.demo"})
public class AppConfig {
}