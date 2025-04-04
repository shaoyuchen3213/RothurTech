package hw.DI;

public class MyApplication {
    private MessageService messageService;

    //constructor injection: The dependency is provided via the constructor
    public MyApplication(MessageService service) {
        this.messageService = service;
    }

    public void processMessage(String msg, String rec) {
        messageService.sendMessage(msg, rec);
    }
}
