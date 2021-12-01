package co.wordbe.advanced.config.v1_proxy.interface_proxy;

import co.wordbe.advanced.app.proxy.v1.OrderControllerV1;
import co.wordbe.advanced.trace.TraceStatus;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {
    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    @Override
    public String order(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.order()");
            // target 호출
            String result = target.order(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
