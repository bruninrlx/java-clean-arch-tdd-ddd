package Bank.application.input;

import Bank.application.BankTransaction;

import java.math.BigDecimal;

public class BankTransactionInput {
    long sourceAccountId;
    long targetAccountId;
    BigDecimal money;
    String activityType;

    public BankTransactionInput(
        long sourceAccountId,
        long targetAccountId,
        BigDecimal money,
        String activityType
    ){}

    public long getSourceAccountId() {
        return sourceAccountId;
    }

    public long getTargetAccountId() {
        return targetAccountId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getActivityType() {
        return activityType;
    }
}
