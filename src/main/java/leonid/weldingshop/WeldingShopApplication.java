package leonid.weldingshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WeldingShopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeldingShopApplication.class, args);
	}

}
