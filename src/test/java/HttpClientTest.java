import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest {



    @Test

    void shouldGetSuccessfullResponseCode() throws IOException {

        HttpClient newClient = new HttpClient("httpbin.org", 80, "/html" );

        assertEquals(200, newClient.getStatusCode() );
    }

    @Test

    void shouldRespond404Test() throws IOException {
        HttpClient newClient = new HttpClient("httpbin.org", 80, "/fsdgdfgdfg");

        assertEquals(404, newClient.getStatusCode());
    }

    @Test
    void shouldReturnContentLength() throws IOException {

        HttpClient newClient = new HttpClient("httpbin.org", 80, "/html" );

        assertEquals("3741", newClient.getHeaderField("Content-Length") );

    }

    @Test
    void shouldReturnContentTypeTest() throws IOException {

        HttpClient newClient = new HttpClient("httpbin.org", 80, "/html" );

        assertEquals("text/html; charset=utf-8", newClient.getHeaderField("Content-Type"));

    }





}
