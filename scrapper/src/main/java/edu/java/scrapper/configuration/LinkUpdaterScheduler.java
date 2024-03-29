package edu.java.scrapper.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class LinkUpdaterScheduler {

    private static final Logger logger = LoggerFactory.getLogger(LinkUpdaterScheduler.class);

    @Scheduled(fixedDelay = 10000) // Запуск каждые 10 секунд
    public void update() {
        // Логирование-заглушка
        logger.info("Scheduled update task executed.");

        // Ваш код обновления ссылок
    }
}
