package qu.brick.spring.web.dao;

import org.hibernate.Session;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Customer;
import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.utils.SessionFactoryUtils;

import java.util.List;

@Component
@Primary
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Customer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session
                    .createQuery("SELECT customer FROM Customer customer WHERE customer.name = :name", Customer.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customer = session.createQuery("SELECT c FROM Customer c").getResultList();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            try (Session session2 = sessionFactoryUtils.getSession()) {
                return session2.get(Customer.class, customer.getId());
            }
        }
    }

    @Override
    public void updateNameById(Long id, String newName) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            customer.setName(newName);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> getProductsById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            List<Product> products = customer.getProducts();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void buyById(Long customerId, Long productId) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            Product product = session.get(Product.class, productId);
            customer.addProduct(product);
            session.getTransaction().commit();
        }
    }

}
