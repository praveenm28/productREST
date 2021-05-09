package com.example1.productrest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.NoSuchElementException;

@RestController

public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/Products")
    public List<Product> list(){

        return service.listAll();
    }

    @GetMapping("/Products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id){
        try{
            Product product = service.getProduct(id);
            return new ResponseEntity<Product>(product,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Products")
    public void add(@RequestBody Product product){
        service.saveProduct(product);
    }

    @PutMapping("/Products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id){
        try {
            Product existingPrd = service.getProduct(id);
            service.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Products/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteProduct(id);

    }
}
