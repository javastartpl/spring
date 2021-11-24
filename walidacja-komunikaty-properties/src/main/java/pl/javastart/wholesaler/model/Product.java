package pl.javastart.wholesaler.model;

import pl.javastart.wholesaler.constraint.SerialNo;

public class Product {
    private String name;
    private String description;
    @SerialNo(startsWith = "PL", codeLength = 5)
    private String serialNumber;

    public Product(String name, String description, String serialNumber) {
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
