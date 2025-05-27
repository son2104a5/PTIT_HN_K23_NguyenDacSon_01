package com.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    private int id;
    private String name;
    private String description;
    private Boolean status;
}
