package com.huike.filter.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Configuration

public class KeyResolverConfiguration {
    @Bean
    public KeyResolver pathKeyResolver() {
        //自定义的KeyResolver
        return new KeyResolver() {
            /**
             * ServerWebExchange :
             *      上下文参数
             */
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just( exchange.getRequest().getPath().toString());
            }
        };
    }
}
