package com.javeriana.web.four.covet19;

import com.javeriana.web.four.covet19.Shared.Infrastructure.Security.XMLSecurity.XMLSecurityParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ImportResource("classpath:dependencies.xml")
public class Covet19Application {

	public static void main(String[] args) {
		XMLSecurityParser.read();
		SpringApplication.run(Covet19Application.class, args);
	}

}
