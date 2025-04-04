package hw.DI;

public class EmailService implements MessageService{
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("Receiver "+ receiver + "receive the message: " + message );
    }
}
