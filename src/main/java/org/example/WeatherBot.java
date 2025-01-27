package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.net.URL;
import java.util.logging.Logger;

public class WeatherBot implements LongPollingSingleThreadUpdateConsumer {

    TelegramClient telegramClient = new OkHttpTelegramClient(System.getenv("BOT_TOKEN"));
    Logger log = Logger.getLogger(WeatherBot.class.getName());
    WeatherBotService weatherBotService;
    EmodjiService emodjiService;
    WeatherTranslateService weatherTranslateService;

    public WeatherBot(EmodjiService emodjiService, WeatherTranslateService weatherTranslateService) {
        this.emodjiService = emodjiService;
        this.weatherTranslateService = weatherTranslateService;
    }


    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            long chat_id = update.getMessage().getChatId();

            weatherBotService = new WeatherBotService(telegramClient);

            String messageFromUser = update.getMessage().getText();

            String answer = "Неизвестная команда.\nВведите /help для отображения команд бота";

            if (messageFromUser.equals("/start")) {

                weatherBotService.sendMessage(chat_id, "Добро пожаловать в бот прогноза погоды!\nПрогноз погоды какого города вас интересует?");

            } else if (!messageFromUser.equals("/start")) {

                WeatherNow weatherNow = weatherBotService.getWeatherNow(messageFromUser, WeatherNow.class);
                String emj = EmojiParser.parseToUnicode(emodjiService.getEmodji(weatherNow));
                String translateWeather = weatherTranslateService.getTranslate(weatherNow);
                answer = emj + " " + translateWeather + "\n" + weatherNow.getMain();
                weatherBotService.sendMessage(chat_id, answer);
            }
        }
    }
}
