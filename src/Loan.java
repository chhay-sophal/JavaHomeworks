import static java.lang.Math.pow;

public class Loan {
    private int id = 0;
    private Person customer;
    private String loanDate;
    private double loanAmount;
    private double yearlyInterestRate;
    private int numberOfYears;

    public Loan() {

    }
    public Loan(Person customer, String loanDate, double loanAmount, double yearlyInterestRate, int numberOfYears) {
        this.id += 1;
        this.customer = customer;
        this.loanDate = loanDate;
        this.loanAmount = loanAmount;
        this.yearlyInterestRate = yearlyInterestRate;
        this.numberOfYears = numberOfYears;
    }

    // Setter method
    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public void setAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    // Getter method
    public Person getCustomer() {
        return customer;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public double getAmount() {
        return loanAmount;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = yearlyInterestRate / 100 / 12;
        return loanAmount * monthlyInterestRate * pow((1 + monthlyInterestRate), numberOfYears) / (pow((1 + monthlyInterestRate), numberOfYears) - 1);
    }

    public double getTotalPayment() {
        int numberOfMonths = numberOfYears * 12;
        return getMonthlyPayment() * numberOfMonths;
    }

    public double getTotalInterest() {
        return getTotalPayment() - loanAmount;
    }

    public int getId() {
        return id;
    }
}
