import org.junit.jupiter.api.Test;
import java.net.http.*;
import static org.junit.jupiter.api.Assertions.*;

class PUT extends EchoTestBase {
    @Test
    void simplePut() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/put"))
                .header("Content-Type", "text/plain")
                .PUT(HttpRequest.BodyPublishers.ofString("put data"))
                .build();

        HttpResponse<String> response = send(request);

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"data\":\"put data\""));
    }
}
