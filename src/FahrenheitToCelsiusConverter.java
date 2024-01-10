import javax.swing.*;

public class FahrenheitToCelsiusConverter {
    public static void main(String[] args) {
        double fahrenheit = getValue("Input value in fahrenheit:");
        double celsius = convertToCelsius(fahrenheit);
        JOptionPane.showMessageDialog(null, fahrenheit + " in fahrenheit is " + celsius + " in celsius.");
    }

    public static double getValue(String prompt) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, prompt));
    }

    public static double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
