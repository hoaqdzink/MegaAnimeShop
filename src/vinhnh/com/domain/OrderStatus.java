package vinhnh.com.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderStatus {
	private int id;
	private int maHD;
	private String tenSP;
	private int maSP;
	private BigDecimal gia;
	private int soLuong;
	private BigDecimal tongTien;
	private Date ngayDat;
	private String stt;
	private String moTa;
	
	
	public OrderStatus() {
	}
	public OrderStatus(int id,int maHD, String tenSP,int maSP, BigDecimal gia, int soLuong, BigDecimal tongTien, Date ngayDat,
			String stt, String moTa) {
		this.id = id;
		this.maHD = maHD;
		this.tenSP = tenSP;
		this.maSP = maSP;
		this.gia = gia;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.ngayDat = ngayDat;
		this.stt = stt;
		this.moTa = moTa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public BigDecimal getTongTien() {
		return tongTien;
	}
	public void setTongTien(BigDecimal tongTien) {
		this.tongTien = tongTien;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getStt() {
		return stt;
	}
	public void setStt(String stt) {
		this.stt = stt;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}
