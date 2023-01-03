package pl.javastart.manytomany;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Product> products = new ArrayList<>();
    private String orderDetails;

    public ClientOrder() { }

    public ClientOrder(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    void addProduct(Product product) {
        products.add(product);
        product.addOrder(this);
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
                "id=" + id +
                ", products=" + products +
                ", orderDetails='" + orderDetails + '\'' +
                '}';
    }
}
