import javax.swing.*;

public class FortuneTellingByPhoneNumber {
    public static void main(String[] args) {
        int phoneNumber;

        while (true) {
            String phoneNumberString = JOptionPane.showInputDialog("Input a 9 or 10-digit phone number (or press Cancel to exit):");

            if (phoneNumberString == null) {
                // User pressed Cancel, exit the program
                JOptionPane.showMessageDialog(null, "Exiting program. No input provided.");
                System.exit(0);
            }

            if (phoneNumberString.length() != 9 && phoneNumberString.length() != 10 || !phoneNumberString.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid 9 or 10-digit number.");
            } else {
                phoneNumber = Integer.parseInt(phoneNumberString);
                int sum = digitSum(phoneNumber);
                String resultDescription = getResultDescription(sum);
                JOptionPane.showMessageDialog(null, "The result is: " + resultDescription);
            }
        }
    }

    static int digitSum(int number) {
        number = Math.abs(number); // Convert negative numbers to positive
        while (number >= 10) {
            int digitsSum = 0;
            while (number > 0) {
                digitsSum += number % 10;
                number /= 10;
            }
            number = digitsSum;
        }
        return number;
    }

    static String getResultDescription(int sum) {
        return switch (sum) {
            case 0, 1, 2, 4, 7 -> "Unlucky";
            case 3, 5, 6, 8, 9 -> "Lucky";
            default -> "Unknown";
        };
    }
}
