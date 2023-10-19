package pl.javastart.apisec.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.javastart.apisec.product.dto.NewProductDto;
import pl.javastart.apisec.product.dto.ProductDto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    ResponseEntity<ProductDto> createProduct(@RequestBody NewProductDto productDto) {
        ProductDto createdProduct = productService.create(productDto);
        URI savedJobOfferUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdProduct.id())
                .toUri();
        return ResponseEntity.created(savedJobOfferUri).body(createdProduct);
    }
}
