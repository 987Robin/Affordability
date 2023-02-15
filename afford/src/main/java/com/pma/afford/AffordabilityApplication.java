package com.pma.afford;

import com.pma.afford.configuration.RSAKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RSAKeyProperties.class)
@SpringBootApplication
public class AffordabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AffordabilityApplication.class, args);
	}

}
