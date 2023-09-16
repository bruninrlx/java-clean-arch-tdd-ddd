package Bank;

import Bank.application.BankTransaction;
import Bank.infra.http.HttpController;
import Bank.infra.http.SpringHttpAdapter.SpringHttpAdapter;
import Bank.infra.repos.factory.DatabaseRepositoryFactory;
import Bank.infra.repos.postgres.jpa_repos.JpaAccountRepository;
import Bank.infra.repos.postgres.jpa_repos.JpaActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    public Main(JpaAccountRepository jpaAccountRepository, JpaActivityRepository jpaActivityRepository) {
        SpringHttpAdapter springHttpAdapter = new SpringHttpAdapter();
        DatabaseRepositoryFactory databaseRepositoryFactory = new DatabaseRepositoryFactory(jpaAccountRepository, jpaActivityRepository);
        BankTransaction bankTransaction = new BankTransaction(databaseRepositoryFactory);
        new HttpController(springHttpAdapter, bankTransaction);
        springHttpAdapter.listen(3000);
    }
}
