package hw.DI;

public class DependencyInjectionDemo {
    public static void main(String[] args) {

        //Inject the depency by passing the concrete email service implementation
        MessageService service = new EmailService();
        MyApplication app = new MyApplication(service);
        app.processMessage("Hello Dependency Injection", "example@example.com");
    }
}
