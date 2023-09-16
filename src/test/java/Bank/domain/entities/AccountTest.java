package Bank.domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;

public class AccountTest {

    @Test
    @DisplayName("should test new account attributes")
    public void deposit() {
        Bank.domain.Account account = new Bank.domain.Account(1, new BigDecimal("20"));
        account.deposit(new BigDecimal("2"));
        assertEquals(account.balance(), new BigDecimal("22"));
    }

    @Test
    @DisplayName("should withdraw money account")
    public void withdraw() {
        Bank.domain.Account account = new Bank.domain.Account(1, new BigDecimal("20"));
        account.withdraw(new BigDecimal("2"));
        assertEquals(account.balance(), new BigDecimal("18"));
    }

    @Test
    @DisplayName("should transfer money")
    public void transfer() {
        Bank.domain.Account account = new Bank.domain.Account(1, new BigDecimal("20"));
        account.withdraw(new BigDecimal("2"));
        assertEquals(account.balance(), new BigDecimal("18"));
    }

    @Test
    @DisplayName("should receive money")
    public void receive() {
        Bank.domain.Account account = new Bank.domain.Account(1, new BigDecimal("20"));
        account.receive(new BigDecimal("2"));
        assertEquals(account.balance(), new BigDecimal("22"));
    }

}
