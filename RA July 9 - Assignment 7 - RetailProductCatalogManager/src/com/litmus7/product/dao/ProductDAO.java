package com.litmus7.product.dao;

import java.util.List;
import com.litmus7.product.dto.*;

public interface ProductDAO {

    void addProduct(Product product);

    Product getProductById(int productId);

    List<Product> getAllProducts();

    void updateProduct(Product product);

    void deleteProduct(int productId);
}
