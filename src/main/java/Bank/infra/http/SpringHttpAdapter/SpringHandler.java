package Bank.infra.http.SpringHttpAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

public class SpringHandler {
    public Mono<ServerResponse> handleWithBody(ServerRequest request, Callback callback) {
       return request.bodyToMono(String.class).flatMap(body -> {
            try {
                Object output = callback.apply(
                    request.queryParams().toSingleValueMap(),
                    request.headers().asHttpHeaders().toSingleValueMap(),
                    new ObjectMapper().readValue(body, Map.class)
                );
                return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(output);
            } catch (JsonProcessingException e) {
                return ServerResponse.unprocessableEntity().bodyValue(e);
            }
       });
    }
    public Mono<ServerResponse> handleWithoutBody(ServerRequest request, Callback callback) {
        Object output = callback.apply(
            request.queryParams().toSingleValueMap(),
            request.headers().asHttpHeaders().toSingleValueMap(),
            null
        );
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(output);
    }
}
