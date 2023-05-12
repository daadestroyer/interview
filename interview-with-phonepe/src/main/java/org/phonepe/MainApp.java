package org.phonepe;

import org.phonepe.entity.Product;
import org.phonepe.repository.InMemoryProductRepository;
import org.phonepe.repository.ProductRepository;
import org.phonepe.service.ProductService;
import org.phonepe.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        ProductRepository productRepository = new InMemoryProductRepository();
        ProductService productService = new ProductServiceImpl(productRepository);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add some initial product");
            System.out.println("2. View product ");
            System.out.println("3. Remove product");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter product id");
                String productId = sc.next();
                System.out.println("Enter product name");
                String productName = sc.next();
                System.out.println("Enter product quantity");
                int productQuantity = sc.nextInt();
                Product newProduct = new Product(productId, productName, productQuantity);
                productService.addProduct(newProduct);
            } else if (choice == 2) {
                System.out.println("Your Inventory is");
                List<Product> allProducts = productService.getAllProducts();
                System.out.println(allProducts);
            } else if (choice == 3) {
                System.out.println("Enter product id");
                String productId = sc.next();
                productService.removeProduct(productId);
            }
            else if(choice == 4){
                System.exit(0);
            }
            else{
                System.out.println("Wrong Choice");
            }
        }

    }
}
