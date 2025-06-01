package dev.vikas.productservices.controllers;

import dev.vikas.productservices.models.Product;
import dev.vikas.productservices.services.FakeStoreProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private FakeStoreProductService fakeStoreProductService;
    public ProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable( "id" ) long product_id ) {
        return fakeStoreProductService.getSingleProducts(product_id);
    }


    @GetMapping("/")
    public List<Product> getAllProducts() {
            return fakeStoreProductService.getProducts();
    }

}
