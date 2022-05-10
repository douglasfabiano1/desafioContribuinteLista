package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public double salaryTax() {
		double salaryMonth;
		salaryMonth = salaryIncome / 12;
		if (salaryMonth < 3000.00) {
			return 0.00;
		} else if (salaryMonth < 5000.00) {
			return 0.10 * salaryIncome;
		} else {
			return 0.20 * salaryIncome;
		}
	}

	public double servicesTax() {
		return servicesIncome * 0.15;
	}

	public double capitalTax() {
		return capitalIncome * 0.20;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double maxRebate, medicalAndEducationalSpends;
		medicalAndEducationalSpends = healthSpending + educationSpending;
		maxRebate = grossTax() * 0.30;
		if (maxRebate < medicalAndEducationalSpends) {
			return maxRebate;
		} else {
			return medicalAndEducationalSpends;
		}
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}
}
