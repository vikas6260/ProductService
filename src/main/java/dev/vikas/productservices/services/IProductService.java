package dev.vikas.productservices.services;

import dev.vikas.productservices.models.Product;

import java.util.List;

public interface IProductService {
    Product getSingleProducts(Long productId);
    List<Product> getProducts();
    boolean deleteSingleProducts(Long productId);
    Product addProduct(Product product);
    Product updateProduct(Product product);
}
