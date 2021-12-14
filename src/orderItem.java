package GUImockfinal;

public class orderItem {

	private String name;
	private String Size;
	private double price;
	
	public orderItem(String n, double p, String s ) {
		this.setName(n);
		this.setPrice(p);
		this.setSize(s);
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
