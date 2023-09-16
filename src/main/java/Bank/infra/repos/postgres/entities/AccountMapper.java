package Bank.infra.repos.postgres.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class AccountMapper {
    @Id
    private Long id;

    BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @OneToMany()
    @JoinColumn(name="source_account_id")
    private List<ActivityMapper> source_accounts;
    @OneToMany()

    @JoinColumn(name="source_account_id")
    private List<ActivityMapper> target_acounts;

    public List<ActivityMapper> getSource_accounts() {
        return source_accounts;
    }

    public void setSource_accounts(List<ActivityMapper> source_accounts) {
        this.source_accounts = source_accounts;
    }

    public List<ActivityMapper> getTarget_acounts() {
        return target_acounts;
    }

    public void setTarget_acounts(List<ActivityMapper> target_acounts) {
        this.target_acounts = target_acounts;
    }
}
