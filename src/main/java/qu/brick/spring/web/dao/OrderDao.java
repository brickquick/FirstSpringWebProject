package qu.brick.spring.web.dao;

import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Order;

import java.util.List;

@Component
public interface OrderDao {
    Order findById(Long id);

    List<Order> findAll();
}
