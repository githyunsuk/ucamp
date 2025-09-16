package com.ucamp.mission.day1;

public class Product {
	private String no;
	private String name;
	private int price;
	
	public Product(String no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	//set/get method 구현
	
	//toString overriding
	//상품정보: P01 - 볼펜, 1000원
	
}
