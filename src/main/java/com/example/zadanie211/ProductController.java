package com.example.zadanie211;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/list")
    String allProducts(Model model, @RequestParam(required = false) ProductCategory category) {
        List<Product> products;
        if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.allProducts();
        }
        model.addAttribute("products", products);
        return "list";
    }

    @PostMapping("/add")
    String home(@RequestParam(required = false) String name,
                @RequestParam(required = false) double price,
                @RequestParam(required = false) ProductCategory category) {
        productRepository.addProduct(new Product(name, price, category));
        return "redirect:/list";
    }
}
