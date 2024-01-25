package vinhnh.com.domain;

import java.math.BigDecimal;

public class CartDetails {
	private String images;
	private String tenSP;
	private int maSP;
	private BigDecimal donGia;
	private long soLuong;
	private BigDecimal thanhTien;
	
	public CartDetails() {
	}
	public CartDetails(String images, String tenSP, int maSP, BigDecimal donGia, long soLuong, BigDecimal thanhTien) {
		this.images = images;
		this.tenSP = tenSP;
		this.maSP = maSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
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
	public long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public BigDecimal getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(BigDecimal thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	
}
