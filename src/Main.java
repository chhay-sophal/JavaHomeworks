import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose an option:\n");

        System.out.print("1. Create an loan for a customer\n");
        System.out.print("2. Delete an customer's loan\n");
        System.out.print("3. Update an customer's loan\n");
        System.out.print("4. Search an customer's loan\n");
        System.out.print("5. Exit\n");
        int userInput = scanner.nextInt();

        LoanList loanList = new LoanList();

        switch (userInput){
            case 1:
                System.out.print("Customer's info: ");
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

                Person person = new Person(firstName, lastName, sex, dateOfBirth, placeOfBirth, phoneNumber);

                LocalDate today = LocalDate.now();

                System.out.print("Loan amount: ");
                double loanAmount = scanner.nextDouble();
                System.out.print("Loan amount: ");
                double yearlyInterestRate = scanner.nextDouble();
                System.out.print("Loan amount: ");
                int numberOfYears = scanner.nextInt();
                Loan loan = new Loan(person, today.toString(), loanAmount, yearlyInterestRate, numberOfYears);

                loanList.addItem(loan);

                break;
            default:
                break;
        }

//        Person person1 = new Person(
//                "Chhay",
//                "Sophal",
//                "Male",
//                "02/10/2003",
//                "Siem Reap",
//                "078414369");
//
//        Person person2 = new Person(
//                "Phanny",
//                "Oudom",
//                "Male",
//                "02/10/2003",
//                "Siem Reap",
//                "078414369");

//        Loan loan1 = new Loan(
//                person1,
//                "14/01/2024",
//                8000,
//                5,
//                6);
//        Loan loan2 = new Loan(
//                person2,
//                "24/01/2024",
//                1000,
//                5,
//                3);

//        loanList.addItem(loan1);
//        loanList.addItem(loan2);
//
//        System.out.print(loanList.searchItem(1));
//        System.out.print(loanList.searchItem(2));

        scanner.close();
    }
}