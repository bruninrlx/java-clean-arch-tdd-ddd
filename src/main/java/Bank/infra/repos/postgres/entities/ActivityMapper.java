package Bank.infra.repos.postgres.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import Bank.infra.repos.postgres.entities.AccountMapper;
@Entity
@Table(name = "activities")
public class ActivityMapper {
    @Id
    private String code;
    private String type;
    private BigDecimal money;
    private Long source_account_id;
    private Long target_account_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="target_account_id", referencedColumnName="id", insertable = false, updatable = false)
    private AccountMapper targetAccounts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="source_account_id", referencedColumnName="id", insertable = false, updatable = false)
    private AccountMapper sourceAccounts;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getSource_account_id() {
        return source_account_id;
    }

    public void setSource_account_id(Long source_account_id) {
        this.source_account_id = source_account_id;
    }

    public Long getTarget_account_id() {
        return target_account_id;
    }

    public void setTarget_account_id(Long target_account_id) {
        this.target_account_id = target_account_id;
    }

    public AccountMapper getTargetAccounts() {
        return targetAccounts;
    }

    public void setTargetAccounts(AccountMapper targetAccounts) {
        this.targetAccounts = targetAccounts;
    }

    public AccountMapper getSourceAccounts() {
        return sourceAccounts;
    }

    public void setSourceAccounts(AccountMapper sourceAccounts) {
        this.sourceAccounts = sourceAccounts;
    }
}



