package Solucion_Reto3.Reto3_Desarrollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties
@SpringBootApplication
@EntityScan(basePackages = {"Solucion_Reto3.Reto3_Desarrollo.Modelo"})
        
public class Reto3DesarrolloApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto3DesarrolloApplication.class, args);
	}

}
