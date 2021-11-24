package pl.javastart.fragments;

class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String icon;

    public Product(Long id, String name, String description, double price, String icon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
