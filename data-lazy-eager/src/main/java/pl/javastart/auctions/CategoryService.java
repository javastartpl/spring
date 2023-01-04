package pl.javastart.auctions;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @Transactional
    public Optional<Double> getAvgPriceForCategory(long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            List<Auction> auctions = existingCategory.getAuctions();
            double priceSum = auctions.stream().mapToDouble(Auction::getBuyNowPrice).sum();
            double avgPrice = priceSum / auctions.size();
            return Optional.of(avgPrice);
        } else {
            return Optional.empty();
        }
    }
}
