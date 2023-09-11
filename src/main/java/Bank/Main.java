package Bank;


import Bank.infra.http.HttpController;
import Bank.infra.http.SpringHttpAdapter.SpringHttpAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
        SpringHttpAdapter springHttpAdapter = new SpringHttpAdapter();
        new HttpController(springHttpAdapter);
        springHttpAdapter.listen(3000);
    }
}
