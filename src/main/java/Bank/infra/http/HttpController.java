package Bank.infra.http;

public class HttpController {
    public HttpController(HttpServer springBootAdapter) {
        springBootAdapter.on("get", "/testinhoo", (params, headers, body) -> {
            return body;
        });
        springBootAdapter.on("post", "/testinho2", (params, headers, body) -> {
            return params;
        });
    }
}