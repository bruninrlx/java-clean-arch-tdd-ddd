package Bank.application;

import Bank.application.input.BankTransactionInput;
import Bank.infra.repos.factory.DatabaseRepositoryFactory;
import Bank.infra.repos.postgres.jpa_repos.JpaAccountRepository;
import Bank.infra.repos.postgres.jpa_repos.JpaActivityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BankTransactionTest {
    @Autowired
    JpaAccountRepository jpaAccountRepository;

    @Autowired
    JpaActivityRepository jpaActivityRepository;

    @Test
    @DisplayName("should make a bank transaction")
    public void bankTransaction() {
        DatabaseRepositoryFactory databaseRepositoryFactory = new DatabaseRepositoryFactory(this.jpaAccountRepository, this.jpaActivityRepository);
        BankTransaction bankTransaction = new BankTransaction(databaseRepositoryFactory);
        Map<String, String> output = bankTransaction.execute(new BankTransactionInput(1, 2, new BigDecimal("2"), "transfer"));
        Map<String, String> mock = new HashMap<>();
        mock.put("money transfered", new BigDecimal("2").toString());
        assertEquals(output, mock);
    }
}

