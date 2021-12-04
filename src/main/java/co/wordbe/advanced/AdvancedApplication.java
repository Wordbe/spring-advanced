package co.wordbe.advanced;

import co.wordbe.advanced.config.v1_proxy.ConcreteProxyConfig;
import co.wordbe.advanced.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import co.wordbe.advanced.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import co.wordbe.advanced.config.v3_proxyfactory.ProxyFactoryConfigV1;
import co.wordbe.advanced.config.v3_proxyfactory.ProxyFactoryConfigV2;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import co.wordbe.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
@Import(ProxyFactoryConfigV2.class)
@SpringBootApplication(scanBasePackages = "co.wordbe.advanced.app.proxy")
public class AdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
