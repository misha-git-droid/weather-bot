package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class WeatherBotService {

    Logger log = Logger.getLogger(WeatherBotService.class.getName());
    WeatherNow weatherNow;
    URL urlWeatherNow;
    TelegramClient telegramClient;

    public WeatherBotService(TelegramClient telegramClient) {
        this.telegramClient = telegramClient;
    }

    public void sendMessage(long chatId, String text) {
        SendMessage message = SendMessage
                .builder()
                .chatId(chatId)
                .text(text)
                .build();

        try {
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            log.info("Ошибка при отправке сообщения пользователю");
            e.printStackTrace();
        }
    }

    public WeatherNow getWeatherNow(String city, Class<WeatherNow> model) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            urlWeatherNow = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + System.getenv("API_WEATHER_TOKEN"));
        } catch (MalformedURLException e) {
            log.info("При создании url произошла ошибка!");
            e.printStackTrace();
        }

        try {
            weatherNow = objectMapper.readValue(urlWeatherNow, model);
        } catch (Exception e) {
            log.info("Произошла ошибка во время парсинга json в pojo");
            e.printStackTrace();
        }

        return weatherNow;
    }


}
