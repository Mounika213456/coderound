import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankApplication {
    
    
    private Map<String, List<Account>> customers = new HashMap<>();
    
   
    private List<Transaction> transactions = new ArrayList<>();

   
    public void onboardNewCustomer(String customerName) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new CurrentAccount());
        accounts.add(new SavingsAccount(500));
        customers.put(customerName, accounts);
    }
    
    
    public void moveMoney(String customerName, int fromAccountIndex, int toAccountIndex, double amount) {
        List<Account> accounts = customers.get(customerName);
        Account fromAccount = accounts.get(fromAccountIndex);
        Account toAccount = accounts.get(toAccountIndex);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        transactions.add(new Transaction(customerName, fromAccount, toAccount, amount));
    }
    
    
    public void makePayment(String customerName, int fromAccountIndex, String recipientName, double amount) {
        List<Account> accounts = customers.get(customerName);
        Account fromAccount = accounts.get(fromAccountIndex);
        Account toAccount = customers.get(recipientName).get(0);
        fromAccount.withdraw(amount * 1.0005); 
        toAccount.deposit(amount);
        transactions.add(new Transaction(customerName, fromAccount, toAccount, amount * 1.0005));
    }
    
   
   
    
    
    public void processTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            String customerName = transaction.getCustomerName();
            Account fromAccount = transaction.getFromAccount();
            Account toAccount = transaction.getToAccount();
            double amount = transaction.getAmount();
            if (fromAccount != null) {
                fromAccount.withdraw(amount);
            }
            if (toAccount != null) {
                toAccount.deposit(amount);
            }
            this.transactions.add(transaction);
            sendNotification(transaction);
        }
    }
    
    
    public List<Transaction> getTransactionsForReconciliation() {
        return transactions;
    }
    
    
    abstract class Account {
        protected double balance;
        
        public double getBalance() {
            return balance;
        }
        
        public void deposit(double amount) {
            balance += amount;
        }
        
        public abstract void withdraw(double amount);
    }
    
    class CurrentAccount extends Account {
        public void withdraw(double amount) {
            balance -= amount;
        }
    }
    
    class SavingsAccount extends Account {
        public SavingsAccount(double joiningBonus) {
            balance = joiningBonus;
        }
        
        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
            }
        }
        
        public void addInterest() {
            balance += balance * 0.005;
        }
    }
    
    
    class Transaction {
        privateString description;
    private BigDecimal amount;

    public Transaction(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }
	 Transaction processedTransaction = new Transaction(
                transaction.getAccountType(), transaction.getType(),transaction.getAmount(), new Date());
            transactionList.add(processedTransaction);
        }
        lastTransactionDate = new Date();
       
        sendTransactionNotifications(transactionList);
    }
  
}

}
