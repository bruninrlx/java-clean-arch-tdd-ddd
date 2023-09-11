package Bank.infra.http.SpringHttpAdapter;
import Bank.infra.http.HttpServer;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunctions;

import java.util.Objects;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class SpringHttpAdapter implements HttpServer {
    RouterFunctions.Builder route;

    public SpringHttpAdapter(){
        this.route = route();
    }

    @Override
    public void on(String method, String url, Callback callback) {
        if(Objects.equals(method, "get"))
            this.route.add(route().GET(url, request -> new SpringHandler().handleWithoutBody(request, callback)).build());
        if(Objects.equals(method, "post"))
            this.route.add(route().POST(url, request -> new SpringHandler().handleWithBody(request, callback)).build());
        if(Objects.equals(method, "patch"))
            this.route.add(route().PATCH(url, request -> new SpringHandler().handleWithBody(request, callback)).build());
        if(Objects.equals(method, "put"))
            this.route.add(route().PUT(url, request -> new SpringHandler().handleWithBody(request, callback)).build());
        if(Objects.equals(method, "delete"))
            this.route.add(route().DELETE(url, request -> new SpringHandler().handleWithBody(request, callback)).build());
    }

    @Override
    public void listen(Integer port){
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(this.route.build());
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        reactor.netty.http.server.HttpServer server = reactor.netty.http.server.HttpServer.create().port(port);
        server.handle(adapter).bindNow();
        System.out.println("Server started on port 3000. Press Ctrl+C to stop.");
    }

}

