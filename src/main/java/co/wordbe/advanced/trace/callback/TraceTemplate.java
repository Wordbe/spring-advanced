package co.wordbe.advanced.trace.callback;

import co.wordbe.advanced.trace.TraceStatus;
import co.wordbe.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {
    private final LogTrace trace;


    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}