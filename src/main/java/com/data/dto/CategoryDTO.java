package com.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private int id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;

    private Boolean status;
}
