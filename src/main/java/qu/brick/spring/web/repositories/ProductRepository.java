package qu.brick.spring.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qu.brick.spring.web.data.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    // @Query("select p from Product p where p.cost between ?1 and ?2")
    List<Product> findAllByCostBetween(Integer min, Integer max);

    // @Query("select p from Product p where p.title = :title")
    Optional<Product> findByTitle(String title);

    void deleteById(Long id);
}
