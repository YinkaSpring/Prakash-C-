package com.pg.price;

import java.util.HashMap;
import java.util.Map;

public class ItemPriceProvider {
	private static Map<String,Double> priceMap = new HashMap<>();
	static{
		priceMap.put("Apple",Double.valueOf(35));
		priceMap.put("Banana",Double.valueOf(20));
		priceMap.put("Melon",Double.valueOf(50));
		priceMap.put("Lime",Double.valueOf(15));
	}
	public static Double getPrice(String key){
		return priceMap.get(key);
	}
}
