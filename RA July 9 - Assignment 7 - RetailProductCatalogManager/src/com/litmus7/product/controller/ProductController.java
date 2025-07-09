package com.litmus7.product.controller;

import com.litmus7.product.dto.Product;
import com.litmus7.product.dto.Response;
import com.litmus7.product.service.ProductService;
import com.litmus7.product.service.ProductServiceImpl;

import java.util.List;

public class ProductController {

    public static final int SUCCESS_STATUS = 200;
    public static final int ERROR_STATUS = 500;

    private ProductService productService = new ProductServiceImpl();


    public Response<String> addProduct(Product product) {
        return productService.addProduct(product);
    }

    public Response<Product> getProductById(int productId) {
        return productService.getProductById(productId);
    }

    public Response<List<Product>> getAllProducts() {
        return productService.getAllProducts();
    }

    public Response<String> updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    public Response<String> deleteProduct(int productId) {
        return productService.deleteProduct(productId);
    }
}
