package co.wordbe.advanced.app.v5;

import co.wordbe.advanced.trace.callback.TraceTemplate;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {
    private final OrderServiceV5 orderServiceV1;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderServiceV1, LogTrace trace) {
        this.orderServiceV1 = orderServiceV1;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String orderId) {
        return template.execute("OrderControllerV5.request()", () -> {
            orderServiceV1.orderItem(orderId);
            return "OK";
        });
    }
}
