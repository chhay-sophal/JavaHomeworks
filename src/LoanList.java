import java.util.ArrayList;
import java.util.List;

public class LoanList {
    private final List<Loan> loans;

    public LoanList() {
        this.loans = new ArrayList<>();
    }

    public LoanList(List<Loan> initialLoans) {
        this.loans = new ArrayList<>(initialLoans);
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

    public void updateItem() {
        // Implementation depends on specific update logic
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
