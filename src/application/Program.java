package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();

		List<TaxPayer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			Double salary = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			Double services = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			Double capital = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			Double health = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			Double education = sc.nextDouble();
			
			list.add(new TaxPayer(salary, services, capital, health, education));
		}

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Resumo do " + (i + 1) + "o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f%n", list.get(i).grossTax());
			System.out.printf("Abatimento: %.2f%n", list.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f%n", list.get(i).netTax());
		}
		sc.close();
	}
}
