package com.pg.basket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.pg.price.ItemPriceProvider;

public class BasketPriceCalculator {
	
	public void calculateCost(List<String> cart){
	
		Map<String, Integer> countMap = cart.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1))); 
		perItemPrice(countMap);
		
	}
	
	private void perItemPrice(Map<String, Integer> countMap){		
		Map<String, Double> perItemCostMap = new HashMap<>();
		Iterator<String> keySetItr = countMap.keySet().iterator();
		while(keySetItr.hasNext()){	
			String key = keySetItr.next();
			if("Apple".equalsIgnoreCase(key) || "Banana".equalsIgnoreCase(key)){
				perItemCostMap.put(key, countMap.get(key)*ItemPriceProvider.getPrice(key));				
			}
			if("Melon".equalsIgnoreCase(key)){
				int count = (countMap.get(key)%2+countMap.get(key)/2);				
				perItemCostMap.put(key, count*ItemPriceProvider.getPrice(key));
			}
			if("Lime".equalsIgnoreCase(key)){
				int count = (countMap.get(key)%3+(countMap.get(key)/3)*2);				
				perItemCostMap.put(key, count*ItemPriceProvider.getPrice(key));				
			}
			System.out.println(""+key + " price is :"+perItemCostMap.get(key));
		}
			
		
		System.out.println("Total Cost:"+perItemCostMap.values().stream().reduce(0.0, Double::sum));
	}
	
}
