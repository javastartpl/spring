package pl.javastart.apisec.product;

import org.springframework.data.repository.ListCrudRepository;

interface ProductRepository extends ListCrudRepository<Product, Long> {
}
