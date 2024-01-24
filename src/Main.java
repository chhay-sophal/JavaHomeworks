import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Choose an option:\n");

            System.out.print("1. Create a loan for a customer\n");
            System.out.print("2. Delete a customer's loan\n");
            System.out.print("3. Update a customer's loan\n");
            System.out.print("4. Search a customer's loan\n");
            System.out.print("5. Exit\n");
            int userInput = scanner.nextInt();

            LoanList loanList = new LoanList();

            if (userInput == 1) {
                System.out.print("Create a loan for a customer\n");
                System.out.print("Customer's info: \n");

                System.out.print("First name: ");
                String firstName = scanner.next();

                System.out.print("Last name: ");
                String lastName = scanner.next();

                System.out.print("Sex: ");
                String sex = scanner.next();

                System.out.print("Date of birth: ");
                String dateOfBirth = scanner.next();

                System.out.print("Place of birth: ");
                String placeOfBirth = scanner.next();

                System.out.print("Phone number: ");
                String phoneNumber = scanner.next();

                System.out.print("Loan amount: ");
                double loanAmount = scanner.nextDouble();

                System.out.print("Yearly interest rate: ");
                double yearlyInterestRate = scanner.nextDouble();

                System.out.print("Number of years: ");
                int numberOfYears = scanner.nextInt();

                LocalDate today = LocalDate.now();

                Person person = new Person(firstName, lastName, sex, dateOfBirth, placeOfBirth, phoneNumber);
                Loan loan = new Loan(person, today.toString(), loanAmount, yearlyInterestRate, numberOfYears);
                loanList.addItem(loan);
            } else if (userInput == 2) {
                System.out.print("Delete a customer's loan\n");
                System.out.print("Input the customer's loan ID: ");
                int id = scanner.nextInt();
                loanList.deleteItem(id);
            } else if (userInput == 3) {
                System.out.print("Update a customer's loan\n");
                System.out.print("Input the customer's loan ID: ");
                int id = scanner.nextInt();

                Loan loan = loanList.searchItem(id);

                if (loan != null) {
                    System.out.print("Old loan date: " + loan.getLoanDate());
                    String date = scanner.next();

                    System.out.print("Old loan amount: " + loan.getAmount());
                    double amount = scanner.nextInt();

                    System.out.print("Old yearly interest rate: " + loan.getYearlyInterestRate());
                    double yearlyInterestRate = scanner.nextDouble();

                    System.out.print("New number of year: " + loan.getNumberOfYears());
                    int numberOfYears = scanner.nextInt();

                    loanList.updateItem(id, date, amount, yearlyInterestRate, numberOfYears);

                    System.out.print("New loan date: " + loan.getLoanDate());
                    System.out.print("New loan amount: " + loan.getAmount());
                    System.out.print("New yearly interest rate: " + loan.getYearlyInterestRate());
                    System.out.print("Old number of year: " + loan.getNumberOfYears());
                } else {
                    System.out.print("Loan with customer id " + id + " not found!\n");
                }
            } else if (userInput == 4) {
                System.out.print("Search a customer's loan\n");
                System.out.print("Input the customer's loan ID: ");
                int id = scanner.nextInt();
                Loan loan = loanList.searchItem(id);
                if (loan != null) {
                    System.out.print(loan.getCustomer().getFirstName());
                } else {
                    System.out.print("Loan with id " + id + " not found!\n");
                }
            } else if (userInput == 5) {
                System.out.print("Exiting the program...");
                break;
            } else {
                System.out.print("Invalid input!\n");
            }
        }
        scanner.close();
    }
}