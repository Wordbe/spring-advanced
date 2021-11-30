package co.wordbe.advanced.proxy.pureproxy.proxy;

import co.wordbe.advanced.proxy.pureproxy.proxy.code.ProxyPatternClient;
import co.wordbe.advanced.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }
}
