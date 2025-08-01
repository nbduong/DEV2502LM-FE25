package com.lab7.lab7.controller;


import com.lab7.lab7.entity.Category;
import com.lab7.lab7.repository.CategoryRepository;
import com.lab7.lab7.repository.ProductRepository;
import com.lab7.lab7.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/category-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("category", new Category());
        return "category/category-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("category", categoryService.getCategoryById(id).orElse(null));
        return "category/category-form";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @PostMapping("/create/{id}")
    public String updateCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category){
        category.setId(id);
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
        return "redirect:/category";
    }
}
