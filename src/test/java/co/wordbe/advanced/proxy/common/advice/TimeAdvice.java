package co.wordbe.advanced.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long start = System.currentTimeMillis();

        // 타겟을 찾아 invoke 해준다.
        Object result = invocation.proceed();

        long end = System.currentTimeMillis();
        log.info("TimeProxy 실행 완료. 실행 시간: {}", end - start);
        return result;
    }
}
