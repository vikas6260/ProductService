package dev.vikas.productservices.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class FakeStoreProductDto {
    private long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

};
