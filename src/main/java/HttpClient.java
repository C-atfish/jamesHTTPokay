import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;

public class HttpClient {

    int statuscode;
    StringBuilder result = new StringBuilder();


    private HashMap<String, String> headerFields = new HashMap<>();





    // constructor
public HttpClient(String host, int port, String requestTarget) throws IOException {


    result = new StringBuilder();
    Socket socket = new Socket(host, port);
    String request = "GET " + requestTarget + " HTTP/1.1\r\n" +
            "Connection: close\r\n" +
            "Host:" + host +"\r\n" +
            "\r\n";

    socket.getOutputStream().write(

            (request).getBytes()
    );

String statusLine  = readLine(socket);
    statuscode = Integer.parseInt(statusLine.split(" ")[1]);



String headerLine;

while(!(headerLine = readLine(socket)).isBlank()){


    int coloPos = headerLine.indexOf(':');
    String key = headerLine.substring(0, coloPos);
    String value = headerLine.substring(coloPos+1).trim();
    headerFields.put(key, value);

}
    System.out.println(headerLine);

}





public String readLine(Socket socket) throws IOException {

    StringBuilder result = new StringBuilder();


    InputStream in  = socket.getInputStream();

    int c;

    // While the inputstream has more bytes, and it doesnt meet a new line
    while ((c = socket.getInputStream().read()) != -1 && c != '\r') {
        result.append((char) c);


    }

    in.read();
    return result.toString();





}



    public int getStatusCode() {


        return statuscode;
    }

    public String getHeaderField(String headerField) {


        return headerFields.get(headerField);


    }
}
