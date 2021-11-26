package co.wordbe.advanced.app.v1;

import co.wordbe.advanced.trace.TraceStatus;
import co.wordbe.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 traceV1;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderRepositoryV1.save()");
            // 저장 로직
            if ("ex".equals(itemId)) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            traceV1.end(status);
        } catch (Exception e) {
            traceV1.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }
}
