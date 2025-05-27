package com.data.controller;

import com.data.dto.CategoryDTO;
import com.data.model.Category;
import com.data.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/categoryList";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model, HttpServletRequest request) {
        model.addAttribute("category", new CategoryDTO());
        return "category/formAdd";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") CategoryDTO category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/formAdd";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/update/{id}")
    public String postCategoryForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        return "category/formUpdate";
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") int id, @Valid @ModelAttribute("category") CategoryDTO category, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "category/formUpdate";
        }
        category.setId(id);
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
