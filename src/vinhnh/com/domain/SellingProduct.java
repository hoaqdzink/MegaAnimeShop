package vinhnh.com.domain;

import java.math.BigDecimal;

public class SellingProduct {
	private int id;
	private String characterName;
	private String nameProduct;
	private BigDecimal price;
	private String image;
	private long purchaseQuantity;
	
	
	public SellingProduct() {
	}
	public SellingProduct(int id, String characterName, String nameProduct, BigDecimal price, String image,
			long purchaseQuantity) {
		this.id = id;
		this.characterName = characterName;
		this.nameProduct = nameProduct;
		this.price = price;
		this.image = image;
		this.purchaseQuantity = purchaseQuantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(long purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	
	
}
