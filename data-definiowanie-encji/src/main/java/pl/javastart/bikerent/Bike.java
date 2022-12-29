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
}
