package co.wordbe.advanced.config.v3_proxyfactory;

import co.wordbe.advanced.config.AppV1Config;
import co.wordbe.advanced.config.AppV2Config;
import co.wordbe.advanced.config.v6_aop.aspect.LogTraceAspect;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {
    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
