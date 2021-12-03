package co.wordbe.advanced.proxy.proxyfactory;

import co.wordbe.advanced.proxy.common.advice.TimeAdvice;
import co.wordbe.advanced.proxy.common.service.ServiceImpl;
import co.wordbe.advanced.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProxyFactoryTest {
    @Test
    void 인터페이스가_있으면_JDK_동적프록시를_사용한다() {
        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue(); // 인터페이스 프록시를 만들 수 있다.
        assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }
}
