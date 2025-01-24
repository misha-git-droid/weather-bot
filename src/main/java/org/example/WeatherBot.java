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
    WeatherBotService weatherBotService;
    URL aUrl;

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            long chat_id = update.getMessage().getChatId();

            weatherBotService = new WeatherBotService();

            String messageFromUser = update.getMessage().getText();

            String answer = "Неизвестная команда.\nВведите /help для отображения команд бота";

            if (weatherBotService.isCity(messageFromUser)) {
                String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + messageFromUser + "&units=metric&lang=ru&appid=" + System.getenv("API_WEATHER_TOKEN");

                try {
                    answer = weatherBotService.jsonToPojo(weatherUrl, WeatherNow.class, messageFromUser);

                } catch (NotFoundCityException e) {
                    SendMessage message = SendMessage
                            .builder()
                            .chatId(chat_id)
                            .text(e.getMessage())
                            .build();

                    try {
                        telegramClient.execute(message);
                    } catch (TelegramApiException a) {
                        log.info("Ошибка при отправке сообщения пользователю");
                        a.printStackTrace();
                    }
                }

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


            }

//            if (messageFromUser.equals("/start")) {
//
//                //String answer = weatherBotService.jsonToPojo(weatherUrl, WeatherNow.class);
//
//                String answer = "Добро пожаловать в бота прогноза погоды!\n" +
//                        "Напишите город, погоду которого вы хотите узнать:";
//
//                // не получится отправить юзеру объект, надо его превратить перед отправкой в текстовый формат
//                SendMessage message = SendMessage
//                        .builder()
//                        .chatId(chat_id)
//                        .text(answer)
//                        .build();
//
//                try {
//                    telegramClient.execute(message);
//                } catch (TelegramApiException e) {
//                    log.info("Ошибка при отправке сообщения пользователю");
//                    e.printStackTrace();
//                }


        }
    }
}
