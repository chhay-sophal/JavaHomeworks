import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterBillCalculator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input the old meter reading: ");
        int oldReading = Integer.parseInt(reader.readLine());

        System.out.print("Input the new meter reading: ");
        int newReading = Integer.parseInt(reader.readLine());

        int unitsConsumed = calculateUnitsConsumed(oldReading, newReading);
        double totalBill = calculateBill(unitsConsumed);

        System.out.println("Total bill is: " + totalBill + " riels.\n");
        reader.close();
    }

    public static int calculateUnitsConsumed(int oldReading, int newReading) {
        return newReading - oldReading;
    }

    public static double calculateBill(int unitsConsumed) {
        double billAmount = 0;

        if (unitsConsumed <= 10) {
            billAmount = unitsConsumed * 440;
        } else if (unitsConsumed <= 15) {
            billAmount = 10 * 440 + (unitsConsumed - 10) * 550;
        } else if (unitsConsumed <= 30) {
            billAmount = 10 * 440 + 5 * 550 + (unitsConsumed - 15) * 770;
        } else {
            billAmount = 10 * 440 + 5 * 550 + 15 * 770 + (unitsConsumed - 30) * 1050;
        }

        return billAmount;
    }
}
