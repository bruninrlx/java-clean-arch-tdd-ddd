package Bank.infra.repos.postgres;

import Bank.domain.Account;
import Bank.domain.repository.AccountRepository;
import Bank.infra.repos.postgres.entities.AccountMapper;
import Bank.infra.repos.postgres.jpa_repos.JpaAccountRepository;

public class AccountsRepositoryPostgres implements AccountRepository {
    final JpaAccountRepository repository;

    public AccountsRepositoryPostgres(JpaAccountRepository repository){
        this.repository = repository;
    }

    @Override
    public Account getAccountById(long accountId) {
        AccountMapper accountMapper = this.repository.findById(accountId);
        return new Account(accountMapper.getId(), accountMapper.getBalance());
    }

    @Override
    public void save(Account account) {
        AccountMapper accountMapper = new AccountMapper();
        accountMapper.setBalance(account.balance());
        accountMapper.setId(account.getId());
        this.repository.save(accountMapper);
    }
}
