package qu.brick.spring.web.repositories;

import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.dao.ProductDao;
import qu.brick.spring.web.dao.ProductDaoImpl;
import qu.brick.spring.web.utils.SessionFactoryUtils;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;
    private SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
    private ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);

    @PostConstruct
    public void init() {
        sessionFactoryUtils.init();
        try {
            productDao.saveOrUpdate(new Product("Bread", BigInteger.valueOf((long) (Math.random() * 100))));
            productDao.saveOrUpdate(new Product("Milk", BigInteger.valueOf((long) (Math.random() * 100))));
            productDao.saveOrUpdate(new Product("Apples", BigInteger.valueOf((long) (Math.random() * 100))));
            productDao.saveOrUpdate(new Product("Bananas", BigInteger.valueOf((long) (Math.random() * 100))));
            productDao.saveOrUpdate(new Product("Oranges", BigInteger.valueOf((long) (Math.random() * 100))));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            sessionFactoryUtils.shutdown();
        }
    }

    public Product findById(Long id) {
        return productDao.findById(id);
//        return sessionFactoryUtils.getSession().createNamedQuery("Product.findById", Product.class)
//                .setParameter("id", id).getSingleResult();
    }

    public int getProductsSize() {
        return products.size();
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void update(Product product) {
        productDao.saveOrUpdate(product);
    }

//    public boolean addProduct(Product product) {
//        if (isTitleExist(product.getTitle())) {
//            return false;
//        }
//        product.setId((long) products.size() + 1);
//        products.add(product);
//        return true;
//    }
//
//    private boolean isTitleExist(String title) {
//        for (Product product : products) {
//            if (product.getTitle().equals(title)) {
//                return true;
//            }
//        }
//        return false;
//    }

}
