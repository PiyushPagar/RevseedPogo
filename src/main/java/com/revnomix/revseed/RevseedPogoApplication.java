package com.revnomix.revseed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.revnomix.revseed"})
@SpringBootApplication
public class RevseedPogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevseedPogoApplication.class, args);
	}

}
