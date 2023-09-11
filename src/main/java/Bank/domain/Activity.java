package Bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class Activity {

    private final String ActivityCode;
    private final long sourceAccountId;
    private final long targetAccountId;
    private final LocalDateTime timestamp;
    private final BigDecimal money;
    private final String activityType;

    public Activity(
        long sourceAccountId,
        long targetAccountId,
        BigDecimal money,
        String activityType
    ) {
        this.money = money;
        this.ActivityCode = new ActivityCode(new GregorianCalendar(), 1).getValue();
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = LocalDateTime.now();
        this.activityType = activityType;
    }

    public String getActivityCode() {
        return this.ActivityCode;
    }

    public long getSourceAccountId() {
        return this.sourceAccountId;
    }

    public long getTargetAccountId() {
        return this.targetAccountId;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public String getActivityType() {
        return this.activityType;
    }
}
