package Bank.infra.repos.postgres.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import Bank.infra.repos.postgres.entities.AccountMapper;
@Entity
@Table(name = "activities")
public class ActivityMapper {
    @Id
    private long source_account_id;
    @Id
    private long target_account_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_order")
    private AccountMapper accountMapper;

}



