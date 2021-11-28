package co.wordbe.advanced.app.v4;

import co.wordbe.advanced.trace.logtrace.LogTrace;
import co.wordbe.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
    private final OrderServiceV4 orderServiceV1;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String orderId) {

        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderServiceV1.orderItem(orderId);
                return "OK";
            }
        };
        return template.execute("OrderControllerV4.request()");
    }
}
