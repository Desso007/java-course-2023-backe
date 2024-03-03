package edu.java.bot;

import java.util.ArrayList;
import java.util.List;

import edu.java.bot.configuration.ApplicationConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotApplication.class, args);
    }
}

@RestController
class CommandController {

    private final ApplicationConfig applicationConfig;
    private final List<String> trackedLinks;

    public CommandController(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
        this.trackedLinks = new ArrayList<>();
    }

    @PostMapping("/start")
    public String startCommand() {
        return "Регистрация пользователя";
    }

    @PostMapping("/help")
    public String helpCommand() {
        return "Список команд:\n/start - зарегистрировать пользователя\n/help - вывести окно с командами\n/track - начать отслеживание ссылки\n/untrack - прекратить отслеживание ссылки\n/list - показать список отслеживаемых ссылок";
    }

    @PostMapping("/track")
    public String trackCommand() {
        return "Логика для команды /track";
    }

    @PostMapping("/untrack")
    public String untrackCommand() {
        return "Логика для команды /untrack";
    }

    @PostMapping("/list")
    public String listCommand() {
        if (trackedLinks.isEmpty()) {
            return "Список отслеживаемых ссылок пуст";
        } else {
            StringBuilder stringBuilder = new StringBuilder("Отслеживаемые ссылки:\n");
            for (String link : trackedLinks) {
                stringBuilder.append(link).append("\n");
            }
            return stringBuilder.toString();
        }
    }
}
