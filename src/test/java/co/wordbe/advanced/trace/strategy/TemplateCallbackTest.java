package co.wordbe.advanced.trace.strategy;

import co.wordbe.advanced.trace.strategy.code.template.Callback;
import co.wordbe.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV1() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.excute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        timeLogTemplate.excute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람다
     */
    @Test
    void callbackV2() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.excute(() -> log.info("비즈니스 로직1 실행"));
        timeLogTemplate.excute(() -> log.info("비즈니스 로직2 실행"));
    }
}
