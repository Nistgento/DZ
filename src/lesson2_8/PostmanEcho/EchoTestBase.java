package lesson2_8.PostmanEcho;

import java.net.http.*;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;

public class EchoTestBase {
    protected static final String BASE_URL = "https://postman-echo.com";
    protected HttpClient client;

    @BeforeEach
    void init() {
        client = HttpClient.newHttpClient();
    }

    protected HttpResponse<String> send(HttpRequest request) throws Exception {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
