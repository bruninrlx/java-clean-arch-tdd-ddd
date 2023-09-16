package Bank.domain.entities;

import Bank.domain.Account;
import Bank.domain.Activity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTest {
    @Test
    @DisplayName("should instance activity")
    public void deposit() {
        Activity activity = new Activity(1, 2, new BigDecimal("2"), "transfer");
        assertEquals(activity.getSourceAccountId(), 1);
        assertEquals(activity.getTargetAccountId(), 2);
        assertEquals(activity.getMoney(), new BigDecimal("2"));
        assertEquals(activity.getActivityType(), "transfer");
    }
}
