package Bank.infra.repos.factory;

import Bank.domain.factory.RepositoryFactory;
import Bank.domain.repository.AccountRepository;
import Bank.domain.repository.ActivityRepository;
import Bank.infra.repos.postgres.AccountsRepositoryPostgres;
import Bank.infra.repos.postgres.ActivitiesRepositoryPostgres;
import Bank.infra.repos.postgres.jpa_repos.JpaAccountRepository;
import Bank.infra.repos.postgres.jpa_repos.JpaActivityRepository;

public class DatabaseRepositoryFactory implements RepositoryFactory {
    final JpaAccountRepository jpaAccountRepository;
    final JpaActivityRepository jpaActivityRepository;

    public DatabaseRepositoryFactory(JpaAccountRepository jpaAccountRepository, JpaActivityRepository jpaActivityRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
        this.jpaActivityRepository = jpaActivityRepository;
    }

    @Override
    public AccountRepository createAccountRepository() {
        return new AccountsRepositoryPostgres(this.jpaAccountRepository);
    }

    @Override
    public ActivityRepository createActivityRepository() {
        return new ActivitiesRepositoryPostgres(this.jpaActivityRepository);
    }
}
