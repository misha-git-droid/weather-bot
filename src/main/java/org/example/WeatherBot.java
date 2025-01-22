package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.net.URL;
import java.util.logging.Logger;

public class WeatherBot implements LongPollingSingleThreadUpdateConsumer {

    TelegramClient telegramClient = new OkHttpTelegramClient(System.getenv("BOT_TOKEN"));
    Logger log = Logger.getLogger(WeatherBot.class.getName());
    String city;
    String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?lat=57.09&lon=65.32&units=metric&lang=ru&appid=" + System.getenv("API_WEATHER_TOKEN");
    WeatherBotService weatherBotService;
    URL aUrl;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            long chat_id = update.getMessage().getChatId();
            weatherBotService = new WeatherBotService();

            // сделать: если сообщение от пользователя пустое, то обработать как ошибку
            String messageFromUser = update.getMessage().getText();

            if (messageFromUser.equals("/start")) {

                String answer = weatherBotService.jsonToPojo(weatherUrl, WeatherNow.class);

                // не получится отправить юзеру объект, надо его превратить перед отправкой в текстовый формат
                SendMessage message = SendMessage
                        .builder()
                        .chatId(chat_id)
                        .text(answer)
                        .build();

                try {
                    telegramClient.execute(message);
                } catch (TelegramApiException e) {
                    log.info("Ошибка при отправке сообщения пользователю");
                    e.printStackTrace();
                }

            } else {
                SendMessage message = SendMessage
                        .builder()
                        .chatId(chat_id)
                        .text("Неизвестная команда.\nВведите /help для отображения команд бота")
                        .build();

                try {
                    telegramClient.execute(message);
                } catch (TelegramApiException e) {
                    log.info("Ошибка при отправке сообщения пользователю");
                    e.printStackTrace();
                }
            }
        }
    }



}
