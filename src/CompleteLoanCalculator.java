import java.util.Scanner;

public class CompleteLoanCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter loan amount: $");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter annual interest rate (as a decimal): ");
        double annualInterestRate = scanner.nextDouble() * 100; // Convert back to percentage

        System.out.print("Enter loan period in years: ");
        double loanPeriodYears = scanner.nextDouble();

        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        double numberOfPayments = loanPeriodYears * 12;

        double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, numberOfPayments);

        System.out.println("Payment\tPrincipal\tInterest\tRemaining Balance");
        double remainingBalance = loanAmount;

        for (int i = 0; i < numberOfPayments; i++) {
            double interest = remainingBalance * monthlyInterestRate;
            double principal = monthlyPayment - interest;
            remainingBalance -= principal;

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\n", i + 1, principal, interest, remainingBalance);
        }

        scanner.close();
    }

    public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, double numberOfPayments) {
        return loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }
}
