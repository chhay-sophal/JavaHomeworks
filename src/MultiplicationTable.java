public class MultiplicationTable {

    public static void main(String[] args) {
        printTableHeader();
        printTableBody();
    }

    private static void printTableHeader() {
        System.out.printf("%4s", " "); // Indent for the first column
        System.out.printf("%5s Multiplication Table\n", " ");
        System.out.printf("%3s", " ");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
    }

    private static void printTableBody() {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d", i);
            printRow(i);
        }
    }

    private static void printRow(int rowNum) {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%5d", rowNum * i);
        }
        System.out.println();
    }
}
