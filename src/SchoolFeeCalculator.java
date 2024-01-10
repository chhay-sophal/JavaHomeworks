public class SchoolFeeCalculator {

    public static void main(String[] args) {
        double initialFee = 10000; // Initial fee
        double targetFee = 20000; // Target fee
        double annualIncrease = 0.07; // Annual increase percentage

        int years = calculateYearsToReachTargetFee(initialFee, targetFee, annualIncrease);

        System.out.println("It takes " + years + " years to reach or exceed $" + targetFee);
    }

    public static int calculateYearsToReachTargetFee(double initialFee, double targetFee, double annualIncrease) {
        int years = 0;

        while (initialFee < targetFee) {
            initialFee *= (1 + annualIncrease); // Calculate the fee for the next year
            years++; // Increment the number of years
        }

        return years;
    }
}
