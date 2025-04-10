package kr.co.fitzstock.config;

import org.slf4j.bridge.SLF4JBridgeHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    @PostConstruct
    public void init() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
}