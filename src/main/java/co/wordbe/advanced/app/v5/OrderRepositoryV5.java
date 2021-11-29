package co.wordbe.advanced.app.v5;

import co.wordbe.advanced.trace.callback.TraceTemplate;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepositoryV5 {
    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        template.execute("OrderRepositoryV5.save()", () -> {
            // 저장 로직
            if ("ex".equals(itemId)) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }
}
