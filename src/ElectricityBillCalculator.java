import javax.swing.JOptionPane;

public class ElectricityBillCalculator {
    private static double remainingBill = 0;

    public static void main(String[] args) {
        int oldReading = getMeterReading("Input the old meter reading:");
        int newReading = getMeterReading("Input the new meter reading:");

        int unitsConsumed = calculateUnitsConsumed(oldReading, newReading);
        double totalBill = calculateBill(unitsConsumed);

        JOptionPane.showMessageDialog(null, "Total bill is: " + totalBill + " riel.");
    }

    public static int getMeterReading(String prompt) {
        String input = JOptionPane.showInputDialog(null, prompt);
        return Integer.parseInt(input);
    }

    public static int calculateUnitsConsumed(int oldReading, int newReading) {
        return newReading - oldReading;
    }

    public static double calculateBill(int unitsConsumed) {
        double billAmount = 0;

        if (unitsConsumed <= 50) {
            billAmount = unitsConsumed * 610;
        } else if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 720;
        } else if (unitsConsumed <= 200) {
            billAmount = unitsConsumed * 830;
        } else if (unitsConsumed <= 300) {
            billAmount = unitsConsumed * 940;
        } else {
            billAmount = unitsConsumed * 1050;
        }

        billAmount += remainingBill;

        if (billAmount < 100) {
            remainingBill += billAmount;
            return 0;
        } else {
            return billAmount;
        }
    }
}
