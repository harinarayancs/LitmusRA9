package com.litmus7.product.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.product.controller.ProductController;
import com.litmus7.product.dto.Product;
import com.litmus7.product.dto.Response;

public class ProductApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductController controller = new ProductController();

        while (true) {
            System.out.println("\n==== Product Catalog Menu ====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Stock Quantity: ");
                    int stock = sc.nextInt();

                    Product newProduct = new Product(id, name, category, price, stock);
                    Response<String> addResponse = controller.addProduct(newProduct);
                    System.out.println(addResponse.getMessage());
                    break;

                case 2:
                    System.out.print("Enter Product ID to view: ");
                    int searchId = sc.nextInt();
                    Response<Product> viewRes = controller.getProductById(searchId);
                    if (viewRes.getStatusCode() == ProductController.SUCCESS_STATUS) {
                        Product p = viewRes.getData();
                        System.out.println("ID: " + p.getProductId() + ", Name: " + p.getName() +
                                ", Category: " + p.getCategory() + ", Price: ₹" + p.getPrice() +
                                ", Stock: " + p.getStockQuantity());
                    } else {
                        System.out.println(viewRes.getMessage());
                    }
                    break;

                case 3:
                    Response<List<Product>> allRes = controller.getAllProducts();
                    List<Product> products = allRes.getData();
                    if (products != null && !products.isEmpty()) {
                        for (Product p : products) {
                            System.out.println("ID: " + p.getProductId() + ", Name: " + p.getName() +
                                    ", Category: " + p.getCategory() + ", Price: ₹" + p.getPrice() +
                                    ", Stock: " + p.getStockQuantity());
                        }
                    } else {
                        System.out.println(allRes.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();
                    
                    Response<Product> res = controller.getProductById(updateId);
                    if (res.getStatusCode() != ProductController.SUCCESS_STATUS) {
                        System.out.println("Product not found. Update failed.");
                        return;
                    }
                    sc.nextLine(); // consume newline

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new category: ");
                    String newCat = sc.nextLine();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter new stock: ");
                    int newStock = sc.nextInt();

                    Product updatedProduct = new Product(updateId, newName, newCat, newPrice, newStock);
                    Response<String> updateRes = controller.updateProduct(updatedProduct);
                    System.out.println(updateRes.getMessage());
                    break;

                case 5:
                    System.out.print("Enter Product ID to delete: ");
                    int delId = sc.nextInt();
                    Response<String> delRes = controller.deleteProduct(delId);
                    System.out.println(delRes.getMessage());
                    break;

                case 6:
                    System.out.println("Thank you for using Retail Product Catalog Manager. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
