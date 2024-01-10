import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAnimalYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int userYear = getUserYear(reader);

        int baseYears = 1996;
        int gapYear = calculateGapYear(userYear, baseYears);
        String userZodiac = findKhmerZodiac(gapYear);

        displayZodiacResult(userYear, userZodiac);
        reader.close();
    }

    public static int getUserYear(BufferedReader reader) throws IOException {
        System.out.print("Find Khmer Zodiac Animal\n");
        System.out.print("Input your Christian year: ");
        return Integer.parseInt(reader.readLine());
    }

    public static int calculateGapYear(int userYear, int baseYears) {
        int gapYear = userYear - baseYears;
        while (gapYear > 12) {
            gapYear -= 12;
        }
        while (gapYear < 0) {
            gapYear += 12;
        }
        return gapYear;
    }

    public static String findKhmerZodiac(int gapYear) {
        return switch (gapYear) {
            case 0 -> "Jute - Rat";
            case 1 -> "Chlov - Ox";
            case 2 -> "Karl - Tiger";
            case 3 -> "Thos - Rabbit";
            case 4 -> "Rorng - Dragon";
            case 5 -> "Masagn - Snake";
            case 6 -> "Momee - Horse";
            case 7 -> "Momay - Goat";
            case 8 -> "Voke - Monkey";
            case 9 -> "Roka - Rooster";
            case 10 -> "Jor - Dog";
            case 11 -> "Kaor - Pig";
            default -> "";
        };
    }

    public static void displayZodiacResult(int userYear, String userZodiac) {
        System.out.println(userYear + " is " + userZodiac + "\n");
    }
}
