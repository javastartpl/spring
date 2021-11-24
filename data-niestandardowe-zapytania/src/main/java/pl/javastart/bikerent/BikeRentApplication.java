package pl.javastart.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikeRentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikeRentApplication.class, args);
        //Dodanie rowerów do bazy
        BikeDto bike1 = new BikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeDto bike2 = new BikeDto(2L, "Merida Kalahari 2020, 29 damski", "MK2020X9876", 25, 80);
        BikeDto bike3 = new BikeDto(3L, "Trek XSpeed 2, 29 cali męski", "TXS229M1234", 30, 120);
        BikeDto bike4 = new BikeDto(4L, "Superior XR Super, 26 cali damski", "SXRS26ASDF", 40, 150);
        BikeService bikeService = context.getBean(BikeService.class);
        bikeService.add(bike1);
        bikeService.add(bike2);
        bikeService.add(bike3);
        bikeService.add(bike4);
        //wypożyczenie
        double payment = bikeService.rentForDay("TXS229M1234", "ABC1234");
        //dostępne rowery
        System.out.println("Wypożyczono rower za kwotę: " + payment);
        int borrowedBikes = bikeService.countBorrowedBikes();
        System.out.println("Liczba wypożyczonych rowerów: " + borrowedBikes);
        System.out.println("Dostępne rowery (cena rosnąco): ");
        bikeService.findAllAvailableBikes().forEach(System.out::println);
    }
}
