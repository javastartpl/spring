package pl.javastart.auctions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AuctionsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AuctionsApplication.class, args);
		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		saveData(categoryRepository);
		categoryRepository.getAvgPriceForCategory(1L)
				.ifPresent(avgPrice -> System.out.println("Średnia cena kategorii to " + avgPrice));
		removeCategoryById(categoryRepository, 1L);
	}

	private static void saveData(CategoryRepository categoryRepository) {
		Auction auction1 = new Auction("Laptop Dell Inspirion", "Niezawodny i szybki komputer do biura i domu", 1500.0, 4999.0);
		Auction auction2 = new Auction("Macbook Pro 15 2020", "Komputer uwielbiany przez miliony", 5000.0, 7999.0);
		Auction auction3 = new Auction("Lenovo Probook 15", "Laptop, który zapewni Ci wygodną pracę", 2999.0, 5999.0);
		Category category1 = new Category("Laptopy", "Znajdź komputer idealny dla siebie");
		category1.addAuction(auction1);
		category1.addAuction(auction2);
		category1.addAuction(auction3);
		categoryRepository.save(category1);
	}

	private static void removeCategoryById(CategoryRepository categoryRepository, long categoryId) {
		categoryRepository.findById(categoryId)
				.ifPresent(categoryRepository::delete);
	}

}
