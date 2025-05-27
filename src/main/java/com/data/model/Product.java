package com.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private MultipartFile image_url;
    private Boolean status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}
