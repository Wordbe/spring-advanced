package co.wordbe.advanced.proxy.cglib;

import co.wordbe.advanced.proxy.cglib.code.TimeMethodInterceptor;
import co.wordbe.advanced.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {
    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class); // 구체 클래스를 상속 받아서 프록시를 생성할 수 있다. 구체 클래스 설정
        enhancer.setCallback(new TimeMethodInterceptor(target)); // 프록시에 적용할 실행 로직

        // concrete 서비스를 상속받아서 프록시가 생성되므로 업캐스팅이 가능하다.
        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();
    }
}
