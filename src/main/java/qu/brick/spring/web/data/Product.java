package qu.brick.spring.web.data;

public class Product {

    private Long id;
    private String title;
    private Integer cost;

    public Product(Long id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
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

    public Integer getCost() {
        return cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

}
