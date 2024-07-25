package entities;

public class Account {
    
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit error: The amount must be greater than zero");
        balance += amount;
    }

    public void withdraw(Double amount) {
        if (amount > balance)
            throw new IllegalArgumentException("Withdraw error: Not enough balance");
        if (amount > withdrawLimit)
            throw new IllegalArgumentException("Withdraw error: The amount exceeds withdraw limit");
        balance -= amount;
    }
}
