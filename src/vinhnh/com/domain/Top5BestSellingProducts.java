package vinhnh.com.domain;

public class Top5BestSellingProducts {
	private String name;
	private long count;
	
	public Top5BestSellingProducts() {
	}
	public Top5BestSellingProducts(String name, long count) {
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	
}
