package co.wordbe.advanced.app.v1;

import co.wordbe.advanced.trace.TraceStatus;
import co.wordbe.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepositoryV1;
    private final HelloTraceV1 traceV1;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderServiceV1.orderItem()");
            orderRepositoryV1.save(itemId);
            traceV1.end(status);
        } catch (Exception e) {
            traceV1.exception(status, e);
            throw e;
        }
    }
}
