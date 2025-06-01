package dev.vikas.productservices.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private long id;
    private String title;
    private Double price;
    private String description;
    private Category category;
    private String image_url;
}
