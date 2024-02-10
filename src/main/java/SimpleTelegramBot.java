import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

public class SimpleTelegramBot extends TelegramLongPollingBot {

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(new SimpleTelegramBot());
            System.out.println("Bot started!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        String userMessageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();


        new Thread(()-> {
                SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(Utils.getWeather(userMessageText));

        try {
            execute(sendMessage);
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
        }).start();
    }

    @Override
    public String getBotUsername() {
        // Уникальное имя вашего бота
        return "Kastet6398FirstJavaBot";
    }

    @Override
    public String getBotToken() {
        // Токен вашего бота, полученный от BotFather в Telegram
        return "6910816505:AAEkdi11_CPzyWH70bFYZXkIZcQ2UEzb7uY";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }


    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
