package dev.vikas.productservices.services;

import dev.vikas.productservices.dtos.FakeStoreProductDto;
import dev.vikas.productservices.models.Category;
import dev.vikas.productservices.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    private RestTemplate restTemplate;
    private String url;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "https://fakestoreapi.in/api/products/";
    }
    @Override
    public Product getSingleProducts(Long productId) {
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(url + productId, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public boolean deleteSingleProducts(Long productId) {
        return false;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if(fakeStoreProductDto == null) {
            return null;
        }
        Product product = new Product();
//        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage_url(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
