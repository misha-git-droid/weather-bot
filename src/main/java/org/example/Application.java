package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import java.net.URL;
import java.util.logging.Logger;

public class Application {
    public static void main(String[] args) {

        Logger log = Logger.getLogger(Application.class.getName());

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(System.getenv("BOT_TOKEN"), new WeatherBot());
            log.info("WeatherBot successfully started!");
            Thread.currentThread().join();
            // Надо не просто вывести данные в консоль, а отправить их в юзеру при /start

        } catch (Exception e) {
            log.info("Ошибка при запуске бота");
            e.printStackTrace();
        }
    }
}