package demo.server;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Hello {

    public String hello(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        enableLogging();

        String url = "http://localhost:1212/hello";
        Endpoint.publish(url, new Hello());
        System.out.println("Service started @ " + url);
    }

    private static void enableLogging() {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
    }

}
