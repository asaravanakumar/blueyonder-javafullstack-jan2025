package com.examples.scloud;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Configuration
public class ResilienceConfig {

//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {
//
//        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build();
//
//        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
//                .failureRateThreshold(50)
//                .slidingWindowSize(10)
//                .waitDurationInOpenState(Duration.of(10, ChronoUnit.SECONDS))
//                .build();
//
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//                .timeLimiterConfig(timeLimiterConfig)
//                .circuitBreakerConfig(circuitBreakerConfig)
//                .build());
//    }
}
