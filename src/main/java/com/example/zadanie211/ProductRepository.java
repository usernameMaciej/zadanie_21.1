package com.example.zadanie211;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Perfumy", 85.39, ProductCategory.OTHER));
        products.add(new Product("Masło", 2.49, ProductCategory.GROCERIES));
        products.add(new Product("Płyn do naczyń", 5.09, ProductCategory.HOUSEHOLD));
        products.add(new Product("Słuchawki", 200.99, ProductCategory.OTHER));
        products.add(new Product("Ser żółty", 7.29, ProductCategory.GROCERIES));
        products.add(new Product("Papier toaletowy", 12.19, ProductCategory.HOUSEHOLD));
        products.add(new Product("Okulary przeciwsłoneczne", 42.79, ProductCategory.OTHER));
        products.add(new Product("Dżem", 4.49, ProductCategory.GROCERIES));
        products.add(new Product("Gąbki", 6.19, ProductCategory.HOUSEHOLD));
    }

    List<Product> allProducts() {
        return products;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> findByCategory(ProductCategory category) {
        List<Product> productsByGroceryCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByGroceryCategory.add(product);
            }
        }
        return productsByGroceryCategory;
    }
}
