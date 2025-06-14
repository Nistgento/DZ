import org.junit.jupiter.api.Test;
import java.net.http.*;
import static org.junit.jupiter.api.Assertions.*;

class PATCH extends EchoTestBase {
    @Test
    void simplePatch() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/patch"))
                .header("Content-Type", "text/plain")
                .method("PATCH", HttpRequest.BodyPublishers.ofString("patch data"))
                .build();

        HttpResponse<String> response = send(request);

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"data\":\"patch data\""));
    }
}