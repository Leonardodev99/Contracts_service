package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date(dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(),ftm);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Enter installments number: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PayPalService());
		contractService.processContract(obj, n);
		
		System.out.println("Installments:");
		for(Installment installments: obj.getInstallments()) {
			System.out.println(installments);
		}
		
		
		sc.close();

		
	}

}
