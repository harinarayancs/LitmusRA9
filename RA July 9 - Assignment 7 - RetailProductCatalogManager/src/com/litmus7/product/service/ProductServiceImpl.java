package com.litmus7.product.service;

import java.util.List;
import com.litmus7.product.controller.ProductController;
import com.litmus7.product.dao.ProductDAO;
import com.litmus7.product.dao.ProductDAOImpl;
import com.litmus7.product.dto.Product;
import com.litmus7.product.dto.Response;
import com.litmus7.product.exception.*;


public class ProductServiceImpl implements ProductService {
	
    private ProductDAO productDAO = new ProductDAOImpl();

    	public Response<String> addProduct(Product product) {
        if (product.getPrice() < 0 || product.getStockQuantity() < 0) {
            throw new InvalidValueException("Value must be non-negative");
        }
        Product duplicate = productDAO.getProductById(product.getProductId());
        if (duplicate != null) {
            throw new ProductExistException("Product already exist");
        }

        try {
            productDAO.addProduct(product);
            return new Response<>(ProductController.SUCCESS_STATUS, "Product added successfully", null);
        } catch (DataAccessException e) {
            return new Response<>(ProductController.ERROR_STATUS, e.getMessage(), null);
        }
    }

    public Response<Product> getProductById(int productId) {
        try {
            Product product = productDAO.getProductById(productId);
            if (product != null) {
                return new Response<>(ProductController.SUCCESS_STATUS, "Product found", product);
            } else {
                return new Response<>(ProductController.ERROR_STATUS, "Product with ID " + productId + " not found", null);
            }
        } catch (DataAccessException e) {
            return new Response<>(ProductController.ERROR_STATUS, e.getMessage(), null);
        }
    }

    public Response<List<Product>> getAllProducts() {
        try {
            List<Product> list = productDAO.getAllProducts();
            return new Response<>(ProductController.SUCCESS_STATUS, "Products fetched", list);
        } catch (DataAccessException e) {
            return new Response<>(ProductController.ERROR_STATUS, e.getMessage(), null);
        }
    }

    
    public Response<String> updateProduct(Product product) {
        if (product.getPrice() < 0 || product.getStockQuantity() < 0) {
            throw new InvalidValueException("Value must be non-negative");
        }

        try {
            productDAO.updateProduct(product);
            return new Response<>(ProductController.SUCCESS_STATUS, "Product updated successfully", null);
        } catch (DataAccessException e) {
            return new Response<>(ProductController.ERROR_STATUS, e.getMessage(), null);
        }
    }

    
    public Response<String> deleteProduct(int productId) {
        try {
            productDAO.deleteProduct(productId);
            return new Response<>(ProductController.SUCCESS_STATUS, "Product deleted successfully", null);
        } catch (DataAccessException e) {
            return new Response<>(ProductController.ERROR_STATUS, e.getMessage(), null);
        }
    }
}
