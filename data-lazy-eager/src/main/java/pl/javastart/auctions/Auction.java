package pl.javastart.auctions;

import jakarta.persistence.*;

@Entity
class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double currentPrice;
    private Double buyNowPrice;

    public Auction() {
    }

    public Auction(String title, String description, Double currentPrice, Double buyNowPrice) {
        this.title = title;
        this.description = description;
        this.currentPrice = currentPrice;
        this.buyNowPrice = buyNowPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(Double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", currentPrice=" + currentPrice +
                ", buyNowPrice=" + buyNowPrice +
                '}';
    }
}
