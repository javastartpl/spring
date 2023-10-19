package pl.javastart.apisec.product;

import org.springframework.stereotype.Service;
import pl.javastart.apisec.product.dto.NewProductDto;
import pl.javastart.apisec.product.dto.ProductDto;

import java.util.List;

@Service
class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()))
                .toList();
    }

    public ProductDto create(NewProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.name());
        product.setPrice(productDto.price());
        Product savedProduct = productRepository.save(product);
        return new ProductDto(savedProduct.getId(), savedProduct.getName(), savedProduct.getPrice());
    }
}
