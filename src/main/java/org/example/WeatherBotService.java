package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.net.URL;
import java.util.logging.Logger;

public class WeatherBotService {

    Logger log = Logger.getLogger(WeatherBotService.class.getName());
    WeatherNow weatherNow;
    URL url;

    public String jsonToPojo(String aUrl, Class<WeatherNow> value, String city) throws NotFoundCityException {

        try {
            url = new URL(aUrl);
        } catch (Exception e) {
            log.info("Ошибка при создании урла");
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            weatherNow = objectMapper.readValue(url, value);
        } catch (Exception e) {
            log.info("При парсинге json в pojo произошла ошибка");
            e.printStackTrace();
            throw new NotFoundCityException("Некорректное название города");
        }

        return weatherNow.toString();
    }

    public boolean isCity(String city) {
        return true;
    }

}
