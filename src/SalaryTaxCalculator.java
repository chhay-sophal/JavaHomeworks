import java.util.Scanner;

public class SalaryTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your salary (riels): ");
        double salary = scanner.nextDouble();

        double taxAmount = calculateTax(salary);

        System.out.println("Salary (riels): " + salary);
        System.out.println("Tax Amount (riels): " + taxAmount);

        scanner.close();
    }

    public static double calculateTax(double salary) {
        double tax = 0;
        double[] thresholds = {800000, 1250000, 8000000, 12500000};
        double[] taxRates = {0.05, 0.10, 0.15, 0.20};

        for (int i = thresholds.length - 1; i >= 0; i--) {
            if (salary > thresholds[i]) {
                tax += (salary - thresholds[i]) * taxRates[i];
                salary = thresholds[i];
            }
        }
        return tax;
    }
}
