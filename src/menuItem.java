package GUImockfinal;

public class menuItem {
	private String name;
	private double priceSmall;
	private double priceMedium;
	private double priceLarge;
	
	public menuItem() {
		this("", 0.0, 0.0, 0.0);
	}
	
	public menuItem(String n, double p1, double p2, double p3 ) {
		this.setName(n);
		this.setPriceSmall(p1);
		this.setPriceMedium(p2);
		this.setPriceLarge(p3);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPriceSmall() {
		return priceSmall;
	}
	public void setPriceSmall(double priceSmall) {
		this.priceSmall = priceSmall;
	}
	public double getPriceMedium() {
		return priceMedium;
	}
	public void setPriceMedium(double priceMedium) {
		this.priceMedium = priceMedium;
	}
	public double getPriceLarge() {
		return priceLarge;
	}
	public void setPriceLarge(double priceLarge) {
		this.priceLarge = priceLarge;
	}

}
