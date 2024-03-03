package edu.java.scrapper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {

    @Bean
    public GitHubClient gitHubClient(WebClient.Builder webClientBuilder) {
        WebClient webClient = webClientBuilder.baseUrl("https://api.github.com").build();
        return new GitHubClientImpl(webClient);
    }

    @Bean
    public StackOverflowClient stackOverflowClient(WebClient.Builder webClientBuilder) {
        WebClient webClient = webClientBuilder.baseUrl("https://api.stackexchange.com/2.3").build();
        return new StackOverflowClientImpl(webClient);
    }
}

