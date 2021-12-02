package qu.brick.spring.web.dao;

import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Customer;
import qu.brick.spring.web.data.Order;
import qu.brick.spring.web.data.Product;

import java.util.List;

@Component
public interface ProductDao {

    Product findById(Long id);

    Product findByTitle(String title);

    List<Product> findAll();

    Product saveOrUpdate(Product product);

    void updateTitleById(Long id, String newTitle);

    void deleteById(Long id);

    List<Order> getOrdersById(Long id);

}
