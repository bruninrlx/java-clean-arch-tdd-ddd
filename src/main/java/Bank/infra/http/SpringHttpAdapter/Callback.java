package Bank.infra.http.SpringHttpAdapter;

import java.util.Map;

public interface Callback {
    Object apply(Map<String, String> params, Map<String, String> headers, Map<String, String> body);
}
