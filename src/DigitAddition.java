import javax.swing.JOptionPane;

public class DigitAddition {
    public static void main(String[] args) {
        int number = getInput("Input the number between 100 and 999:");

        int sum = addNumber(number);

        JOptionPane.showMessageDialog(null, "The sum of digits in " + number + " is " + sum);
    }

    public static int getInput(String prompt) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, prompt);
            int parsedInput = Integer.parseInt(input);

            if (parsedInput < 100 || parsedInput > 999) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            } else {
                return parsedInput;
            }
        }
    }

    public static int addNumber(int number) {
        int sum = 0;

        int digit1 = number % 10;
        number /= 10;
        int digit2 = number % 10;
        number /= 10;
        int digit3 = number % 10;
        number /= 10;

        sum = digit1 + digit2 + digit3;

        return sum;
    }
}
