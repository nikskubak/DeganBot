import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class DeganBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        // TODO
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                System.out.print(message.getText());
                message.setText("Вы кто такие? Я вас не звал, идите нахуй");
                sendMessage(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "DeganBot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "431107683:AAEj67esEqx_8GJjI970OhSeJqpiOnACtVo";
    }
}
