package com.litmus7.product.dao;

import java.sql.*;
import java.util.*;
import com.litmus7.product.dto.Product;
import com.litmus7.product.exception.DataAccessException;
import com.litmus7.product.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {
	
	
	public void addProduct(Product product) {
		String query = "insert into products(productId, name, category, price, stockQuantity) values (?,?,?,?,?)";
		try(Connection connection = DBUtil.getConnection();
			PreparedStatement stmt = connection.prepareStatement(query)){
				stmt.setInt(1,product.getProductId());
				stmt.setString(2,product.getName());
				stmt.setString(3,product.getCategory());
				stmt.setDouble(4,product.getPrice());
				stmt.setInt(5,product.getStockQuantity());
				
				stmt.executeUpdate();
		}
		catch(SQLException e) {
	        throw new DataAccessException("Failed to add product",e);

		}
	}
	
	
	public Product getProductById(int productId) {
	    String query = "select * from products where productId = ?";
	    Product product = null;

	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setInt(1, productId);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            product = new Product();  
	            product.setProductId(rs.getInt("productId"));
	            product.setName(rs.getString("name"));
	            product.setCategory(rs.getString("category"));
	            product.setPrice(rs.getDouble("price"));
	            product.setStockQuantity(rs.getInt("stockQuantity"));
	        }

	    } catch (SQLException e) {
	        throw new DataAccessException("Failed to fetch product with ID:" + productId , e);
	    }

	    return product;
	}

	public List<Product> getAllProducts() {
	    String query = "select * from  products";
	    List<Product> productList = new ArrayList<>();

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Product product = new Product(); 
	            product.setProductId(rs.getInt("productId"));
	            product.setName(rs.getString("name"));
	            product.setCategory(rs.getString("category"));
	            product.setPrice(rs.getDouble("price"));
	            product.setStockQuantity(rs.getInt("stockQuantity"));

	            productList.add(product); 
	        }

	    } catch (SQLException e) {
	        throw new DataAccessException("Failed to fetch all products", e);
	    }

	    return productList;
	}

	public void updateProduct(Product product) {
	    String query = "update products set name = ?, category = ?, price = ?, stockQuantity = ? where productId = ?";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement stmt = connection.prepareStatement(query)) {

	        stmt.setString(1, product.getName());
	        stmt.setString(2, product.getCategory());
	        stmt.setDouble(3, product.getPrice());
	        stmt.setInt(4, product.getStockQuantity());
	        stmt.setInt(5, product.getProductId());

	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new DataAccessException("Product not found. Update failed.");
	        }

	    } catch (SQLException e) {
	        throw new DataAccessException("Failed to update product:" + product.getProductId(), e);
	    }
	}
	
	
	public void deleteProduct(int productId) {
	    String query = "delete from products where productId = ?";

	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement stmt = connection.prepareStatement(query)) {

	        stmt.setInt(1, productId);

	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new DataAccessException("Product not found. Deletion failed.");
	        }

	    } catch (SQLException e) {
	        throw new DataAccessException("Failed to delete product with ID:" + productId, e);
	    }
	}


	
}