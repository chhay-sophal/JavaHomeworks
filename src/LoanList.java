import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LoanList {
    private final Vector<Loan> loans;

    public LoanList() {
        this.loans = new Vector<>();
    }

    public LoanList(List<Loan> initialLoans) {
        this.loans = new Vector<>(initialLoans);
    }

    public void addItem(Loan loan) {
        loans.add(loan);
        System.out.print("Loan added with customer name: " + loan.getCustomer().getFirstName() + " " + loan.getCustomer().getLastName() + "\n");
    }

//    public void deleteItem(int id) {
//        for (Loan loan : loans) {
//            if (loan.getId() == id) {
//                return loan;
//            }
//        }
//        loans.removeIf(loan -> loan.getId() == id); // Assuming a unique id field in Loan
//    }

    public void deleteItem(int id){
        int indexToDelete = -1;
        for(int i = 1; i <= loans.size(); i++){
            if (loans.get(i).getId() == id){
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) { // If the item was found
            loans.remove(indexToDelete); // Use efficient list removal method
        } else {
            System.out.print("The item with id " + id + " is not found!");
        }
    }

    public void updateItem(int id, String loanDate, double loanAmount, double yearlyInterestRate, int numberOfYear) {
        int indexToUpdate = -1;
        for(int i = 1; i <= loans.size(); i++){
            if (loans.get(i).getId() == id){
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -1) {
            var loan = loans.get(indexToUpdate);
            System.out.print("Update user name " +
                    loan.getCustomer().getFirstName() +
                    loan.getCustomer().getFirstName());

            loan.setLoanDate(loanDate);
            loan.setAmount(loanAmount);
            loan.setYearlyInterestRate(yearlyInterestRate);
            loan.setNumberOfYears(numberOfYear);
            System.out.print("The item with id " + id + " is updated!\n");
        } else {
            System.out.print("The item with id " + id + " is not found!");
        }
    }

    public Loan searchItem(int id) {
        for (Loan loan : loans) {
            if (loan.getId() == id) {
                return loan;
            }
        }
        return null;
    }
}
