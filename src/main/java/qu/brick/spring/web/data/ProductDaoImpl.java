package qu.brick.spring.web.data;

import org.hibernate.Session;
import qu.brick.spring.web.utils.SessionFactoryUtils;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public Product findByTitle(String title) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session
                    .createQuery("select product from Product product where product.title = :title", Product.class)
                    .setParameter("title", title)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateTitleById(Long id, String newTitle) {
//            HQL Example:
//            session.createQuery("update User u set u.name = :name where u.id = :id")
//                    .setParameter("name", newName)
//                    .setParameter("id", id)
//                    .executeUpdate();
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(newTitle);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            Product productFromDB = session.get(Product.class, product.getId());
            session.getTransaction().commit();
            return productFromDB;
        }
    }

}
