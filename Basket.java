package com.pg.basket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pg.price.ProductType;

public class Basket {

	public static void main(String[] args) {
		List<String> shoppingCart = new ArrayList<>();
		System.out.println("Please one fruit at a time and empty string to finish shopping\n");
		Scanner scanner = new Scanner(System.in);
		String product=null;
		while((product = scanner.nextLine()).length() > 0){			
			shoppingCart.add(ProductType.fromString(product).getProduct());
		}
		BasketPriceCalculator calculator = new BasketPriceCalculator();
		calculator.calculateCost(shoppingCart);
	}

}
