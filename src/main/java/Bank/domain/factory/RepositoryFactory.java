package Bank.domain.factory;

import Bank.domain.repository.AccountRepository;
import Bank.domain.repository.ActivityRepository;

public interface RepositoryFactory {
    AccountRepository createAccountRepository();
    ActivityRepository createActivityRepository();
}
