package demo.client;

import demo.wsclient.Hello;
import demo.wsclient.HelloService;

public class HelloClient {

    public static void main(String[] args) {
        HelloService service = new HelloService();
        Hello hello = service.getHelloPort();
        String text = hello.hello("soap");
        System.out.println(text);
    }

}
