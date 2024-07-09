package com.example.Leonid.WeldingShop;

import com.example.Leonid.WeldingShop.Entities.Gorelka;
import com.example.Leonid.WeldingShop.Entities.WeldingMachine;
import com.example.Leonid.WeldingShop.Repositories.GorelkaRepository;
import com.example.Leonid.WeldingShop.Repositories.WeldingMachineRepository;
import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class WeldingShopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeldingShopApplication.class, args);
//		WeldingMachine weld = new WeldingMachine();
//		weld.setName("Сварог");
//		weld.setPrice(10000);
////		weld.getGorelka().setLength(10);
////		weld.getGorelka().showLength();
//
//		Gorelka gorelka1 = new Gorelka();
//
//
////		gorelka1.setLength(10);
//		GorelkaRepository gorelkaRepo = context.getBean(GorelkaRepository.class);
////		gorelkaRepo.save(gorelka1);
////
		WeldingMachineRepository welds = context.getBean(WeldingMachineRepository.class);
//		weld.setGorelka(gorelka1);
//		welds.save(weld);
		WeldingMachine weldFinded = welds.findById(UUID.fromString("2be08df1-aea7-4d56-b21e-722e5b34a392")).get();
//		weldFinded.setName("Bennny");
//		welds.save(weldFinded);
		welds.deleteById(UUID.fromString("3cb9bdca-f1c2-4225-ba88-7546196401fe"));
		System.out.println(weldFinded);

	}

}
