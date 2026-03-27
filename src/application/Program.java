package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		List <Product>prod = new ArrayList<>();
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			System.out.println("Product #"+i+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char p = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			Double price = sc.nextDouble();
			
			if (p == 'i') {
				System.out.println("Customs free: ");
				double customsFree = sc.nextDouble();
				Product imp = new ImportedProduct(name,price,customsFree);
				prod.add(imp);
			}else if (p == 'c') {
				Product product = new Product(name,price);
				prod.add(product);
			}
			else if (p == 'u') {
				System.out.print("Manufacture Date (dd/MM/yyyy): ");
				String input = sc.next();
				LocalDate manufactureDate = LocalDate.parse(input, fmt1);
				Product product = new UsedProduct(name,price,manufactureDate);
				prod.add(product);
			}
		}
		
			for (Product product : prod) {
			 System.out.println(product.priceTag());
			}
		sc.close();
	}

}
