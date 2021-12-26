package co.wordbe.advanced.rearrange.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class DynamicProxy {

    static class Hello {
        public void sayHello() {
            log.info("Hello");
        }

        public void sayGoodbye() {
            log.info("Goodbye");
        }
    }

    @Test
    void 리플렉션이_올바르게_호출된다() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("co.wordbe.advanced.rearrange.proxy.DynamicProxy$Hello");
        Method sayHello = aClass.getMethod("sayHello");
        Method sayGoodbye = aClass.getMethod("sayGoodbye");

        Hello hello = new Hello();
        invoke(sayHello, hello);
        invoke(sayGoodbye, hello);
    }

    private void invoke(Method method, Hello hello) throws IllegalAccessException, InvocationTargetException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        method.invoke(hello);

        stopWatch.stop();
        log.info("{}", stopWatch.getTotalTimeMillis());
    }
}
