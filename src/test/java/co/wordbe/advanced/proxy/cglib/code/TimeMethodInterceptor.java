package co.wordbe.advanced.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("TimeMethodInterceptor 실행");
        long start = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, args); // method 를 사용해도 되지만 CGLIB 는 성능상 methodProxy 를 권장

        long end = System.currentTimeMillis();
        log.info("TimeMethodInterceptor 실행 완료. 실행 시간: {}", end - start);
        return result;
    }
}
