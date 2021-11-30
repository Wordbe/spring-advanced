package co.wordbe.advanced.proxy.pureproxy.decorator;

import co.wordbe.advanced.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import co.wordbe.advanced.proxy.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }
}
