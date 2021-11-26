package co.wordbe.advanced.app.v3;

import co.wordbe.advanced.trace.TraceStatus;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepositoryV2;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV3.orderItem()");
            orderRepositoryV2.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
