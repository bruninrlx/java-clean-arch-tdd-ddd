package Bank.infra.repos.postgres.jpa_repos;

import Bank.domain.Activity;
import Bank.infra.repos.postgres.entities.ActivityMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JpaActivityRepository extends JpaRepository<ActivityMapper, String> {
   ActivityMapper findByCode(String code);

   List<ActivityMapper> findAllBySourceAccounts_Id(long accountId);
   List<ActivityMapper> findAllByTargetAccounts_Id(long accountId);
}
