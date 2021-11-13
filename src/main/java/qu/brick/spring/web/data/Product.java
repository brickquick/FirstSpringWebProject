package qu.brick.spring.web.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private Long id;
    private String title;
    private BigDecimal cost;

    public Product(Long id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost.setScale(0, RoundingMode.CEILING);
    }

    @Override
    public String toString() {
        return "id: " + id + "; Название: " + title + "; Цена: " +
                cost + "$;";
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

}
