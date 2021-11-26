package co.wordbe.advanced.trace.logtrace;

import co.wordbe.advanced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
