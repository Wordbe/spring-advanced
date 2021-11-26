package co.wordbe.advanced.app.v1;

import co.wordbe.advanced.trace.TraceStatus;
import co.wordbe.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderServiceV1;
    private final HelloTraceV1 traceV1;

    @GetMapping("/v1/request")
    public String request(String orderId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderController.request()");
            orderServiceV1.orderItem(orderId);
            traceV1.end(status);
            return "OK";
        } catch (Exception e) {
            traceV1.exception(status, e);
            throw e;
        }
    }
}
