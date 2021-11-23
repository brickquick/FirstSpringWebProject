package qu.brick.spring.web.data;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    Product findByTitle(String title);

    List<Product> findAll();

    void save(Product product);

    void updateTitleById(Long id, String newTitle);

    void deleteById(Long id);

    Product saveOrUpdate(Product product);

}
