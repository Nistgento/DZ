import org.junit.jupiter.api.Test;
import java.net.http.*;
import static org.junit.jupiter.api.Assertions.*;
import test.java.testng.PostmanEcho.EchoTestBase;

class GET extends EchoTestBase {
    @Test
    void simpleGet() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/get"))
                .GET()
                .build();

        HttpResponse<String> response = send(request);

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"url\":\"" + BASE_URL + "/get\""));
    }
}
