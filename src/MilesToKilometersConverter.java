import java.util.Scanner;

public class MilesToKilometersConverter {
    public static void main(String[] args) {
        double miles = getInput("Input distance in miles: ");
        double kilometers = convertMilesToKilometers(miles);
        displayResult(miles, kilometers);
    }

    public static double getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        double input = scanner.nextDouble();
        scanner.close();
        return input;
    }

    public static double convertMilesToKilometers(double miles) {
        return miles * 1.60934;
    }

    public static void displayResult(double miles, double kilometers) {
        System.out.println(miles + " miles is equal to " + kilometers + " kilometers.");
    }
}
