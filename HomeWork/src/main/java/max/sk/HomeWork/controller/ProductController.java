package max.sk.HomeWork.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import max.sk.HomeWork.model.Product;
import max.sk.HomeWork.repositories.ProductRepository;
import max.sk.HomeWork.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public List<Product> findAllProducts(
            @RequestParam(name = "productId", required = false) Long productId) {
        if (productId == null){
            return productService.findAll();
        }
        productService.deleteProductById(productId);
        return productService.findAll();
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody Product product){
        product.setId(null);
        return productService.saveOrUpdate(product);
    }

}
