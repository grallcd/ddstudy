package com.ddstudy.chain;

import org.junit.jupiter.api.Test;

/**
 * @Classname ChainTest
 * @Description TODO
 * @Date 2020/7/15
 * @Author Grain Rain
 */
public class ChainTest {

    @Test
    void testChain() {

        AbstractLogger logger = new InfoLogger()
                .setNext(new DebugLogger()
                        .setNext(new WarnLogger()
                                .setNext(new ErrorLogger())));

        Log infoLog = new Log("This is an info log", LogType.INFO);
        Log debugLog = new Log("This is a debug log", LogType.DEBUG);
        Log warnLog = new Log("This is a warn log", LogType.WARN);
        Log errorLog = new Log("This is an error log", LogType.ERROR);

        logger.handleRequest(infoLog);
        logger.handleRequest(debugLog);
        logger.handleRequest(warnLog);
        logger.handleRequest(errorLog);

    }
}
