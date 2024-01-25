package vinhnh.com.domain;

import java.math.BigDecimal;

public class FavoriteList {
	private String images;
	private String tenSP;
	private int maSP;
	private BigDecimal donGia;
	
	
	public FavoriteList() {
		
	}
	public FavoriteList(String images, String tenSP, int maSP, BigDecimal donGia) {
		
		this.images = images;
		this.tenSP = tenSP;
		this.maSP = maSP;
		this.donGia = donGia;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public BigDecimal getDonGia() {
		return donGia;
	}
	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}
	
	
}
