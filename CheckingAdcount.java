public class CheckingAccount extends Account {
    private double overdraftProtection;

    public CheckingAccount(double balance, double protect) {
        super(balance + protect);
        this.overdraftProtection = protect;
    }

    public CheckingAccount(double balance) {
        this(balance, -1.0);
    }

    @Override
    public boolean withdraw(double amount) {
        double overdraftNeeded = amount - this.balance;
        if (overdraftNeeded > 0) {
            if (this.overdraftProtection < 0 || this.overdraftProtection < overdraftNeeded) {
                return false;
            } else {
                this.balance = 0.0;
                this.overdraftProtection -= overdraftNeeded;
                return true;
            }
        } else {
            if (this.balance < amount) {
                return false;
            } else {
                this.balance -= amount;
                return true;
            }
        }
    }
}