package edu.java.bot.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "database-access-type", havingValue = "jpa", matchIfMissing = true)
    public LinkService jpaLinkService(JpaLinkRepository linkRepository) {
        return new JpaLinkService(linkRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "database-access-type", havingValue = "jdbc")
    public LinkService jdbcLinkService(JdbcLinkRepository linkRepository) {
        return new JdbcLinkService(linkRepository);
    }
}
