package Bank.infra.http;

import Bank.infra.http.SpringHttpAdapter.Callback;

public interface HttpServer {
    public void on(String method, String url, Callback callback);
    public void listen(Integer port);
}
