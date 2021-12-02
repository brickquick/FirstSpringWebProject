package qu.brick.spring.web.dao;

import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Customer;
import qu.brick.spring.web.data.Product;

import java.util.List;

@Component
public interface CustomerDao {

    Customer findById(Long id);

    Customer findByName(String name);

    List<Customer> findAll();

    Customer saveOrUpdate(Customer customer);

    void updateNameById(Long id, String newName);

    void deleteById(Long id);

    void buyById(Long customerId, Long productId);

    List<Product> getProductsById(Long id);

}
