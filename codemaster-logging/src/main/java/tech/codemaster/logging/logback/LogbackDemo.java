package tech.codemaster.logging.logback;

import lombok.extern.slf4j.Slf4j;
import tech.codemaster.logging.common.LogginCommonDemo;

/**
 * @author Tom Deng
 * @date 2017-04-07
 **/
@Slf4j
public class LogbackDemo {
    public static void main(String[] args) {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        LogginCommonDemo.test();
    }
}
