package pl.javastart.thymform;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
class PromotionRepository {
    private final List<Promotion> promotions = new LinkedList<>();

    void add(Promotion promotion) {
        promotions.add(0, promotion);
    }

    List<Promotion> findAll() {
        return promotions;
    }
}
