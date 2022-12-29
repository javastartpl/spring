package pl.javastart.bikerent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class Bike {
    @Id
    private Long id;
    private String model;
    private String serialNo;
    private double hourPrice;
    private double dayPrice;
    private String borrowerId;

    public Bike() {
    }

    public Bike(Long id, String model, String serialNo, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.serialNo = serialNo;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                ", borrowerId='" + borrowerId + '\'' +
                '}';
    }
}
