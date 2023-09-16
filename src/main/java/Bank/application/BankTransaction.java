package Bank.application;

import Bank.application.input.BankTransactionInput;
import Bank.domain.Account;
import Bank.domain.Activity;
import Bank.domain.factory.RepositoryFactory;
import Bank.domain.repository.AccountRepository;
import Bank.domain.repository.ActivityRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankTransaction {
    AccountRepository accountRepository;
    ActivityRepository activityRepository;

    public BankTransaction(RepositoryFactory repositoryFactory){
        this.accountRepository = repositoryFactory.createAccountRepository();
        this.activityRepository = repositoryFactory.createActivityRepository();
    }

    public Map<String, String> execute(BankTransactionInput bankTransactionInput){
        Account sourceAccount = this.accountRepository.getAccountById(bankTransactionInput.getSourceAccountId());
        Account targetAccount = this.accountRepository.getAccountById(bankTransactionInput.getTargetAccountId());
        if(bankTransactionInput.getActivityType().equals("withdraw"))
            targetAccount.withdraw(bankTransactionInput.getMoney());
        if(bankTransactionInput.getActivityType().equals("deposit"))
            sourceAccount.deposit(bankTransactionInput.getMoney());
        if(bankTransactionInput.getActivityType().equals("transfer")){
            sourceAccount.transfer(bankTransactionInput.getMoney());
            targetAccount.receive(bankTransactionInput.getMoney());
        }
        this.accountRepository.save(sourceAccount);
        this.accountRepository.save(targetAccount);
        Activity activity = new Activity(
            bankTransactionInput.getSourceAccountId(),
            bankTransactionInput.getTargetAccountId(),
            bankTransactionInput.getMoney(),
            bankTransactionInput.getActivityType()
        );
        this.activityRepository.save(activity);
        Map<String, String> output = new HashMap<>();
        output.put("money transfered", activity.getMoney().toString());
        return output;
    }

}
