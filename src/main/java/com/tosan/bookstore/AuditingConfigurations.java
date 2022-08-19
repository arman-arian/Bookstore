package com.tosan.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfigurations {
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> java.util.Optional.of("Administrator");
    }
}
