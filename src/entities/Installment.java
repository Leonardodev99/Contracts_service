package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	private static DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate douDate;
	private Double amount;
	
	public Installment() {
		
	}

	public Installment(LocalDate douDate, Double amount) {
		
		this.douDate = douDate;
		this.amount = amount;
	}

	public LocalDate getDouDate() {
		return douDate;
	}

	public void setDouDate(LocalDate douDate) {
		this.douDate = douDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return douDate.format(ftm) + "-" + String.format("%.2f", amount);
	}
	

}
