package Bank.infra.repos.postgres.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
public class AccountMapper {
    @Id
    private String account_id;

    BigDecimal balance;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private List<ActivityMapper> activityMappers;

    public AccountMapper() {
    }

    public AccountMapper(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccount_id() {
        return account_id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
