package qu.brick.spring.web.services;

import org.springframework.stereotype.Service;
import qu.brick.spring.web.dao.CustomerDao;
import qu.brick.spring.web.data.Customer;
import qu.brick.spring.web.data.Product;

import java.util.List;

@Service
public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer getById(Long id) {
        return customerDao.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    public void updateNameById(Long id, String newName) {
        customerDao.updateNameById(id, newName);
    }

    public void deleteById(Long id) {
        customerDao.deleteById(id);
    }

    public void buyById(Long customerId, Long productId) {
        customerDao.buyById(customerId, productId);
    }

    public List<Product> getProductsById(Long id) {
        return customerDao.getProductsById(id);
    }

}
