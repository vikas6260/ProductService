package dev.vikas.productservices.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vikas.productservices.dtos.FakeStoreProductDto;
import dev.vikas.productservices.models.Category;
import dev.vikas.productservices.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    private RestTemplate restTemplate;
    private String url;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "https://fakestoreapi.com/products/";
    }
    @Override
    public Product getSingleProducts(Long productId) {
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(url + productId, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String json = objectMapper.writeValueAsString(response.getBody());
//            String statusCode = response.getBody().toString();
//            System.out.println("statusCode: " + statusCode);
//            System.out.println(json);  // Prints body as JSON
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(response.getBody());
//        System.out.println(fakeStoreProductDto.getTitle());
//        System.out.println(fakeStoreProductDto.getCategory());
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getProducts() {
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(url, FakeStoreProductDto[].class);
         FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();
         List<Product> products = new ArrayList<>();
         for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
             products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
         }
        return products;
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
        product.setId(fakeStoreProductDto.getId());
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
