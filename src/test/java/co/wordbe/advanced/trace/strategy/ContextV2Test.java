package co.wordbe.advanced.trace.strategy;

import co.wordbe.advanced.trace.strategy.code.strategy.ContextV2;
import co.wordbe.advanced.trace.strategy.code.strategy.Strategy;
import co.wordbe.advanced.trace.strategy.code.strategy.StrategyLogic1;
import co.wordbe.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.excute(new StrategyLogic1());
        contextV2.excute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.excute(new Strategy() {
            @Override
            public void call() {
                log.info("[익명 내부 클래스]: 비즈니스 로직1 실행");
            }
        });
        contextV2.excute(new Strategy() {
            @Override
            public void call() {
                log.info("[익명 내부 클래스]: 비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략 패턴 람다
     */
    @Test
    void strategyV3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.excute(() -> log.info("[람다]: 비즈니스 로직1 실행"));
        contextV2.excute(() -> log.info("[람다]: 비즈니스 로직2 실행"));
    }
}
