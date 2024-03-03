package edu.java.scrapper;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class test {

    @LocalServerPort
    private int port;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Before
    public void setup() {
        webClientBuilder.baseUrl("http://localhost:" + port);
    }

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // Порт WireMock сервера

    @Test
    public void testGitHubClient() {
        stubFor(get(urlEqualTo("/repos/octocat/hello-world"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{\"name\":\"hello-world\"}")));

        // Здесь вызываете методы вашего GitHubClient и проверяете, что они возвращают ожидаемый результат
    }

    @Test
    public void testStackOverflowClient() {
        stubFor(get(urlEqualTo("/questions/12345"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{\"title\":\"Sample question\"}")));

        // Здесь вызываете методы вашего StackOverflowClient и проверяете, что они возвращают ожидаемый результат
    }
}
