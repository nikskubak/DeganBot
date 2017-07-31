import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class DeganBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        try {
            sendMessage(MessageHandler.getInstance().handleIncomingMessage(update)); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return Constants.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return Constants.BOT_TOKEN;
    }
}
