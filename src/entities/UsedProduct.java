package entities;

import java.time.LocalDate;



public class UsedProduct extends Product {
	private LocalDate manufactureDate;
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate2) {
		super(name, price);
		this.manufactureDate = manufactureDate2;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	@Override
	public String priceTag() {
		
		return super.priceTag()+"Manufacture Date: "+ manufactureDate;
		
	}
}
