package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import java.net.URL;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) {

        Logger log = Logger.getLogger(Application.class.getName());
        EmodjiService emodjiService;
        WeatherTranslateService weatherTranslateService;

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            Emodji emodji = new Emodji();
            WeatherTranslate weatherTranslate = new WeatherTranslate();
            emodjiService = new EmodjiService(emodji);
            weatherTranslateService = new WeatherTranslateService(weatherTranslate);
            botsApplication.registerBot(System.getenv("BOT_TOKEN"), new WeatherBot(emodjiService, weatherTranslateService));
            log.info("WeatherBot successfully started!");
            Thread.currentThread().join();
            // Надо не просто вывести данные в консоль, а отправить их в юзеру при /start

        } catch (Exception e) {
            log.info("Ошибка при запуске бота");
            e.printStackTrace();
        }
    }
}