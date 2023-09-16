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
    ){
      this.sourceAccountId = sourceAccountId;
      this.targetAccountId = targetAccountId;
      this.money = money;
      this.activityType = activityType;
    }

    public long getSourceAccountId() {

        return this.sourceAccountId;
    }

    public long getTargetAccountId() {
        return this.targetAccountId;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public String getActivityType() {
        return this.activityType;
    }
}
