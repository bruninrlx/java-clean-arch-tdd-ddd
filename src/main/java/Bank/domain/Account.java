package Bank.domain;


import java.math.BigDecimal;

public class Account {

    private final long accountId;
    private BigDecimal balance;

    public Account(
        long accountId,
        BigDecimal balance
    ) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public BigDecimal withdraw(BigDecimal money) {
        if(money.compareTo(balance) > 0) throw new IllegalArgumentException("Insufficient balance");
        else this.balance = balance.subtract(money);
        return money;
    }

    public void deposit(BigDecimal money) {
        this.balance = this.balance.add(money);
    }

    public BigDecimal transfer(BigDecimal money) {
        if(money.compareTo(balance) > 0) throw new IllegalArgumentException("Insufficient balance");
        else this.balance = balance.subtract(money);
        return money;
    }

    public void receive(BigDecimal money) {
        this.balance = this.balance.add(money);
    }

    public long getId(){
        return this.accountId;
    }

    public BigDecimal balance (){
        return this.balance;
    }
}
