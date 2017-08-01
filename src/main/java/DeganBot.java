import org.telegram.telegrambots.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class DeganBot extends TelegramLongPollingBot {

    public DeganBot() {

    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if(update.hasMessage() && update.getMessage().hasText()) {
                sendMessage(MessageHandler.getInstance().handleIncomingMessage(update)); // Call method to send the message
            }else if(update.hasMessage() && update.getMessage().hasPhoto()){
                sendPhoto(PhotoHandler.createPhotoMessage(update));
            }
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
