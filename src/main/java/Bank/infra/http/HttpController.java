package Bank.infra.http;

import Bank.application.BankTransaction;
import Bank.application.input.BankTransactionInput;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HttpController {

    public HttpController(HttpServer springBootAdapter, BankTransaction bankTransaction) {
        springBootAdapter.on("post", "/activity", (params, headers, body) -> {
            long sourceAccountId = Long.parseLong(body.get("source_account_id"));
            long targetAccountId = Long.parseLong(body.get("target_account_id"));
            BigDecimal money = new BigDecimal(body.get("money"));
            String activityType = body.get("activity_type");
            BankTransactionInput input = new BankTransactionInput(sourceAccountId, targetAccountId, money, activityType);
            Map<String, String> output = bankTransaction.execute(input);
            return output;
        });
    }
}