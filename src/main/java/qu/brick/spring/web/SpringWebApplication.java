package qu.brick.spring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import qu.brick.spring.web.dao.CustomerDao;
import qu.brick.spring.web.dao.CustomerDaoImpl;
import qu.brick.spring.web.dao.ProductDao;
import qu.brick.spring.web.dao.ProductDaoImpl;
import qu.brick.spring.web.data.Customer;
import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.services.CustomerService;
import qu.brick.spring.web.services.ProductService;
import qu.brick.spring.web.utils.SessionFactoryUtils;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringWebApplication.class, args);

		SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();

		try {
			sessionFactoryUtils.init();
			Product product = new ProductService(new ProductDaoImpl(sessionFactoryUtils)).getById(1L);
			System.out.println(product.toString());
			System.out.println("-----------------------------------------");
//			Customer customer = new CustomerService(new CustomerDaoImpl(sessionFactoryUtils)).getById(1L);
//
//			new CustomerService(new CustomerDaoImpl(sessionFactoryUtils)).buyById(1L, 5L);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactoryUtils.shutdown();
		}

	}

}
