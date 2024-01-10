import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoanCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double principle = getInput("Enter loan amount: ", reader);
        double annualInterestRate = getInput("Enter annual interest rate (in percentage): ", reader);
        int loanTenureInYears = (int) getInput("Enter loan tenure in years: ", reader);

        calculateLoanDetails(principle, annualInterestRate, loanTenureInYears);

        reader.close();
    }

    public static double getInput(String prompt, BufferedReader reader) throws IOException {
        System.out.print(prompt);
        return Double.parseDouble(reader.readLine());
    }

    public static void calculateLoanDetails(double principle, double annualInterestRate, int loanTenureInYears) {
        int loanTenureInMonths = loanTenureInYears * 12;
        double monthlyInterestRate = annualInterestRate / 12 / 100;

        double emi = principle * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenureInMonths)
                / (Math.pow(1 + monthlyInterestRate, loanTenureInMonths) - 1);

        double totalPayment = emi * loanTenureInMonths;
        double totalInterest = totalPayment - principle;

        System.out.println("Monthly Installment (EMI): " + emi);
        System.out.println("Total Payment: " + totalPayment);
        System.out.println("Total Interest: " + totalInterest);
    }
}
