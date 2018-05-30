package com.pg.price;

public enum ProductType {
	APPLE("Apple"), BANANA("Banana"), MELON("Melon"), LIME("Lime");

	private String product;

	ProductType(String product) {
		this.product = product;
	}

	public String getProduct() {
		return this.product;
	}

	public static ProductType fromString(String text) {
		for (ProductType type : ProductType.values()) {
			if (type.product.equalsIgnoreCase(text)) {
				return type;
			}
		}
		return null;
	}
}
