package br.edu.ufop.web.ticket.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SalesModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesModuleApplication.class, args);
	}

}
