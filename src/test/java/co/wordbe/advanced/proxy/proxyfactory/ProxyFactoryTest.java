package co.wordbe.advanced.proxy.proxyfactory;

import co.wordbe.advanced.proxy.common.advice.TimeAdvice;
import co.wordbe.advanced.proxy.common.service.ConcreteService;
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
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();  // 인터페이스 프록시를 만들 수 있다. (JDK 동적 프록시)
        assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }

    @Test
    void 구체클래스만_있으면_CGLIB를_사용한다() {
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.call();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue(); // 클래스 기반 프록시를 만들 수 있다. (CGLIB)
    }

    @Test
    void 인터페이스가_있어도_CGLIB를_사용한다() { // ProxyTargetClass 사
        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceImpl proxy = (ServiceImpl) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue(); // 인터페이스가 있어도 클래스 기반 프록시를 만들 수 있다. (CGLIB)
    }
}
