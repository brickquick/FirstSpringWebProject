package qu.brick.spring.web.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Order;

import java.util.List;

@Component
@Primary
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
