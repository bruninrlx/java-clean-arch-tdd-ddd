package Bank.infra.repos.postgres.jpa_repos;

import Bank.infra.repos.postgres.entities.AccountMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAccountRepository extends JpaRepository<AccountMapper, String> {
}
