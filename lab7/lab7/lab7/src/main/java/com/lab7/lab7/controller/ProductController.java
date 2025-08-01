package com.lab7.lab7.controller;


import com.lab7.lab7.entity.Category;
import com.lab7.lab7.entity.Product;
import com.lab7.lab7.repository.CategoryRepository;
import com.lab7.lab7.repository.ProductRepository;
import com.lab7.lab7.service.CategoryService;
import com.lab7.lab7.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "product/product-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "product/product-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.findById(id).orElse(null));
        return "product/product-form";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @PostMapping("/create/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product){
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);

        return "redirect:/product";
    }
}
