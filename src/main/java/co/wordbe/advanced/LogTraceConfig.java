package co.wordbe.advanced;

import co.wordbe.advanced.trace.logtrace.FieldLogTrace;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
