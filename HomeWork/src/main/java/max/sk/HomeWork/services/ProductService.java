package max.sk.HomeWork.services;

import max.sk.HomeWork.model.Product;
import max.sk.HomeWork.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private int switcher;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        switcher = 0;
    }

    public List<Product> findAll() {
        switcher = 0;
        List<Product> backList = new ArrayList<>();
        if (productRepository.findAll().size() < 10) {
            for (int i = switcher; i < productRepository.findAll().size(); i++) {
                backList.add(productRepository.findAll().get(i));
            }
            return backList;
        }
        for (int i = switcher; i < switcher + 10; i++) {
            backList.add(productRepository.findAll().get(i));
        }
        return backList;
    }

    public List<Product> forwardList() {

        List<Product> backList = new ArrayList<>();
        switcher = switcher + 10;
        if(switcher > productRepository.findAll().size()) {
            switcher = switcher - 10;
        }

        if (productRepository.findAll().size() < 10){
            switcher = 0;
            for(int i = switcher; i < productRepository.findAll().size(); i ++){
                backList.add(productRepository.findAll().get(i));
            }
            return backList;
        }

        if (switcher +10 > productRepository.findAll().size()){
            for (int i = switcher; i < switcher +(productRepository.findAll().size()%10); i++) {
                backList.add(productRepository.findAll().get(i));
            }
            System.out.println(switcher + "  QQQQQQQQQQ  " + productRepository.findAll().size() );

            return backList;
        }

            for (int i = switcher; i < switcher +10; i++) {
                backList.add(productRepository.findAll().get(i));
            }
            return backList;


    }

    public List<Product> backList() {

        switcher = switcher - 10;
        List<Product> backList = new ArrayList<>();
        if(switcher < 0) {
            switcher = switcher + 10;
        }

        if (productRepository.findAll().size() < 10){
            switcher = 0;
            for(int i = switcher; i < productRepository.findAll().size(); i ++){
                backList.add(productRepository.findAll().get(i));
            }
            return backList;
        }
        if (switcher < 0) {
            switcher = 0;
            for (int i = switcher; i < switcher + 10; i++) {
                backList.add(productRepository.findAll().get(i));
            }
            return backList;
        }

        for (int i = switcher; i < switcher + 10; i++) {
            backList.add(productRepository.findAll().get(i));
        }
        return backList;
    }


    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


}
