package co.wordbe.advanced.config.v1_proxy;

import co.wordbe.advanced.app.proxy.v2.OrderControllerV2;
import co.wordbe.advanced.app.proxy.v2.OrderRepositoryV2;
import co.wordbe.advanced.app.proxy.v2.OrderServiceV2;
import co.wordbe.advanced.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import co.wordbe.advanced.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import co.wordbe.advanced.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import co.wordbe.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }
}
