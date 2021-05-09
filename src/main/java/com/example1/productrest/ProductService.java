package com.example1.productrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<Product> listAll(){
        return repo.findAll();
    }
    public void saveProduct(Product product){
        repo.save(product);
    }

    public Product getProduct(int id){
        return repo.findById(id).get();
    }

    public void deleteProduct(int id){
        repo.deleteById(id);
    }
}
