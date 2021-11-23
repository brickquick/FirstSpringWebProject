package qu.brick.spring.web.data;

import java.math.BigInteger;

public class Product {

    private Long id;
    private String title;
    private BigInteger cost;

    public Product(Long id, String title, BigInteger cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

}
