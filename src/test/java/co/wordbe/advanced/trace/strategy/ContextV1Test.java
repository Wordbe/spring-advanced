package co.wordbe.advanced.trace.strategy;

import co.wordbe.advanced.trace.strategy.code.strategy.ContextV1;
import co.wordbe.advanced.trace.strategy.code.strategy.Strategy;
import co.wordbe.advanced.trace.strategy.code.strategy.StrategyLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info("elapsedTime = {}", elapsedTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info("elapsedTime = {}", elapsedTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.excute();

        StrategyLogic1 strategyLogic2 = new StrategyLogic1();
        ContextV1 contextV12 = new ContextV1(strategyLogic2);
        contextV12.excute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직1 실행;");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        log.info("strategyLogic1={}", strategyLogic1.getClass());
        contextV1.excute();

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직1 실행;");
            }
        };
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        log.info("strategyLogic2={}", strategyLogic2.getClass());
        contextV2.excute();
    }

    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직1 실행;");
            }
        });
        contextV1.excute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직1 실행;");
            }
        });
        contextV2.excute();
    }

    @Test
    void strategyV4() {
        // lambda 를 사용하려면 인터페이스에 메소드가 1개만 있어야 한다.
        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스로직1 실행;"));
        contextV1.excute();

        ContextV1 contextV2 = new ContextV1(() -> log. info("비즈니스로직1 실행;"));
        contextV2.excute();
    }
}
