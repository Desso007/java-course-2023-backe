import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

public class ScrapperAPIClient {
    private final WebClient webClient;
    private final String baseUrl;

    public ScrapperAPIClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.webClient = WebClient.create(baseUrl);
    }

    public Mono<URI> registerChat(URI uri) {
        return webClient.post()
            .uri("/api/chat/register")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(uri))
            .retrieve()
            .bodyToMono(URI.class);
    }

    public Mono<URI> addLink(URI chatUri, URI linkUri) {
        return webClient.post()
            .uri("/api/chat/{chatUri}/link/add", chatUri)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(linkUri))
            .retrieve()
            .bodyToMono(URI.class);
    }

    public Mono<List<URI>> getAllLinks(URI chatUri) {
        return webClient.get()
            .uri("/api/chat/{chatUri}/links", chatUri)
            .retrieve()
            .bodyToFlux(URI.class)
            .collectList();
    }



}
