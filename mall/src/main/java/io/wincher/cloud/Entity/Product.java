package io.wincher.cloud.Entity;

public class Product {
	
	private static final long serialVersionUID = 1L;
	
	private String itemCode;
	private String name;
	private String brandName;
	private int price;
	
	public Product() {
	
	}
	public Product(String itemCode, String name, String brandName, int price) {
		this.itemCode = itemCode;
		this.name = name;
		this.brandName = brandName;
		this.price = price;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
