package max.sk.HomeWork.services;

import max.sk.HomeWork.model.Product;
import max.sk.HomeWork.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllByPrice(int min, int max) {
        return productRepository.findAllByCostBetween(min, max);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

}
