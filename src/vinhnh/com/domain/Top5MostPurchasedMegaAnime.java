package vinhnh.com.domain;

public class Top5MostPurchasedMegaAnime {
	private String mageAnime;
	private long countQuantity;
	
	public Top5MostPurchasedMegaAnime() {
	}
	public Top5MostPurchasedMegaAnime(String mageAnime, long countQuantity) {
		this.mageAnime = mageAnime;
		this.countQuantity = countQuantity;
	}
	public String getMageAnime() {
		return mageAnime;
	}
	public void setMageAnime(String mageAnime) {
		this.mageAnime = mageAnime;
	}
	public long getCountQuantity() {
		return countQuantity;
	}
	public void setCountQuantity(long countQuantity) {
		this.countQuantity = countQuantity;
	}
	
	
}
