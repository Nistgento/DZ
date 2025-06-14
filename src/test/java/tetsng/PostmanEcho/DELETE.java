import org.junit.jupiter.api.Test;
import java.net.http.*;
import static org.junit.jupiter.api.Assertions.*;

class DELETE extends EchoTestBase {
    @Test
    void simpleDelete() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/delete"))
                .header("Content-Type", "text/plain")
                .method("DELETE", HttpRequest.BodyPublishers.ofString("delete data"))
                .build();

        HttpResponse<String> response = send(request);

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"data\":\"delete data\""));
    }
}