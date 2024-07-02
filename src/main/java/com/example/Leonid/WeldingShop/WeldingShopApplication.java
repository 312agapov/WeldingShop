package com.example.Leonid.WeldingShop;

import com.example.Leonid.WeldingShop.Entities.WeldingMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WeldingShopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeldingShopApplication.class, args);
		WeldingMachine weld = context.getBean(WeldingMachine.class);
		weld.setName("Сварог");
		weld.setPrice(10000);
		System.out.println(weld);
	}

}
