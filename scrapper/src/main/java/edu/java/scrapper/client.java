package edu.java.scrapper;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class client {

    private final WebClient gitHubWebClient;
    private final WebClient stackOverflowWebClient;

    public client(WebClient.Builder webClientBuilder) {
        this.gitHubWebClient = webClientBuilder.baseUrl("https://api.github.com").build();
        this.stackOverflowWebClient = webClientBuilder.baseUrl("https://api.stackexchange.com").build();
    }

    public Mono<GitHubRepoResponse> getGitHubRepository(String owner, String repoName) {
        return gitHubWebClient.get()
            .uri("/repos/{owner}/{repo}", owner, repoName)
            .retrieve()
            .bodyToMono(GitHubRepoResponse.class);
    }

    public Mono<GitHubUserResponse> getGitHubUser(String username) {
        return gitHubWebClient.get()
            .uri("/users/{username}", username)
            .retrieve()
            .bodyToMono(GitHubUserResponse.class);
    }

    public Mono<StackOverflowQuestionResponse> getStackOverflowQuestion(long questionId) {
        return stackOverflowWebClient.get()
            .uri("/questions/{questionId}", questionId)
            .retrieve()
            .bodyToMono(StackOverflowQuestionResponse.class);
    }

    public Flux<StackOverflowAnswerResponse> getStackOverflowAnswers(long questionId) {
        return stackOverflowWebClient.get()
            .uri("/questions/{questionId}/answers", questionId)
            .retrieve()
            .bodyToFlux(StackOverflowAnswerResponse.class);
    }
}
