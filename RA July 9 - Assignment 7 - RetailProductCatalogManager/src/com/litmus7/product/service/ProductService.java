package com.litmus7.product.service;

import com.litmus7.product.dto.Product;
import com.litmus7.product.dto.Response;
import java.util.List;

public interface ProductService {

    Response<String> addProduct(Product product);

    Response<Product> getProductById(int productId);

    Response<List<Product>> getAllProducts();

    Response<String> updateProduct(Product product);

    Response<String> deleteProduct(int productId);
}
