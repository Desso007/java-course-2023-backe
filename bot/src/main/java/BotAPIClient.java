import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

public class BotAPIClient {
    private final WebClient webClient;
    private final URI baseUrl;

    public BotAPIClient(URI baseUrl) {
        this.baseUrl = baseUrl;
        this.webClient = WebClient.builder().baseUrl(baseUrl.toString()).build();
    }

    public Mono<Void> someBotApiMethod() {
        // Пример вызова API метода
        return webClient.post()
            .uri("/api/some-endpoint")
            .retrieve()
            .bodyToMono(Void.class);
    }


    public void setBaseUrl(URI baseUrl) {
        this.webClient.mutate().baseUrl(baseUrl.toString()).build();
    }
}
