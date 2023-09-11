package Bank.domain.repository;

import Bank.domain.Account;

public interface AccountRepository {
    public Account getAccountById(long accountId);
    public void save(Account account);
}
