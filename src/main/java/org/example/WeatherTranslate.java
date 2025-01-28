package org.example;

import java.util.HashMap;

public class WeatherTranslate {

    HashMap<String, String> enToRuSnow = new HashMap<>();
    HashMap<String, String> enToRuRain = new HashMap<>();
    HashMap<String, String> enToRuThunderstorm = new HashMap<>();
    HashMap<String, String> enToRuDrizzle = new HashMap<>();
    HashMap<String, String> enToRuAtmosphere = new HashMap<>();
    HashMap<String, String> enToRuClear = new HashMap<>();
    HashMap<String, String> enToRuClouds = new HashMap<>();

    public WeatherTranslate() {
        this.init();
    }

    public void init() {
        enToRuSnow.put("light snow", "Лёгкий снег");
        enToRuSnow.put("snow", "Снегопад");
        enToRuSnow.put("heavy snow", "Сильный снегопад");
        enToRuSnow.put("sleet", "Мокрый снег");
        enToRuSnow.put("light shower sleet", "Лёгкий ливень с мокрым снегом");
        enToRuSnow.put("shower sleet", "Ливень с мокрым снегом");
        enToRuSnow.put("light rain and snow", "Небольшой дождь со снегом");
        enToRuSnow.put("rain and snow", "Дождь и снег");
        enToRuSnow.put("light shower snow", "Лёгкий снежный ливень");
        enToRuSnow.put("shower snow", "Ливень из снега");
        enToRuSnow.put("heavy shower snow", "Сильный ливень со снегом");
        //
        enToRuRain.put("light rain", "Лёгкий дождь");
        enToRuRain.put("moderate rain", "Умеренный дождь");
        enToRuRain.put("heavy intensity rain", "Сильный дождь");
        enToRuRain.put("very heavy rain", "Очень сильный дождь");
        enToRuRain.put("extreme rain", "Экстремально сильный дождь");
        enToRuRain.put("freezing rain", "Ледяной дождь");
        enToRuRain.put("light intensity shower rain", "Лёгкий ливень");
        enToRuRain.put("shower rain", "Ливень");
        enToRuRain.put("heavy intensity shower rain", "Сильный ливень");
        enToRuRain.put("ragged shower rain", "Неровный ливень");
        //
        enToRuThunderstorm.put("thunderstorm with light rain", "Гроза с небольшим дождем");
        enToRuThunderstorm.put("thunderstorm with rain", "Гроза с дождем");
        enToRuThunderstorm.put("thunderstorm with heavy rain", "Гроза с сильным дождем");
        enToRuThunderstorm.put("light thunderstorm", "Лёгкая гроза");
        enToRuThunderstorm.put("thunderstorm", "Гроза");
        enToRuThunderstorm.put("heavy thunderstorm", "Сильная гроза");
        enToRuThunderstorm.put("ragged thunderstorm", "Разразившаяся гроза");
        enToRuThunderstorm.put("thunderstorm with light drizzle", "Гроза с лёгкой моросью");
        enToRuThunderstorm.put("thunderstorm with drizzle", "Гроза с моросящим дождём");
        enToRuThunderstorm.put("thunderstorm with heavy drizzle", "Гроза с сильным моросящим дождём");
        //
        enToRuDrizzle.put("light intensity drizzle", "Лёгкой интенсивности морось");
        enToRuDrizzle.put("drizzle", "Морось");
        enToRuDrizzle.put("heavy intensity drizzle", "Сильной интенсивности морось");
        enToRuDrizzle.put("light intensity drizzle rain", "Легкой интенсивности морось с дождём");
        enToRuDrizzle.put("drizzle rain", "Моросящий дождь");
        enToRuDrizzle.put("heavy intensity drizzle rain", "Сильной интенсивности морось с дождём");
        enToRuDrizzle.put("shower rain and drizzle", "Ливень с моросью");
        enToRuDrizzle.put("heavy shower rain and drizzle", "Сильный ливень с моросью");
        enToRuDrizzle.put("shower drizzle", "Моросящий ливень");
        //
        enToRuAtmosphere.put("mist", "Лёгкий туман");
        enToRuAtmosphere.put("smoke", "Дым");
        enToRuAtmosphere.put("haze", "Дымка");
        enToRuAtmosphere.put("sand/dust whirls", "Вихри песка / пыли");
        enToRuAtmosphere.put("fog", "Туман");
        enToRuAtmosphere.put("sand", "Песок");
        enToRuAtmosphere.put("dust", "Пыль");
        enToRuAtmosphere.put("volcanic ash", "Вулканический пепел");
        enToRuAtmosphere.put("squalls", "Шквал");
        enToRuAtmosphere.put("tornado", "Торнадо");
        //
        enToRuClear.put("clear sky", "Чистое небо");
        //
        enToRuClouds.put("few clouds", "Мало облаков");
        enToRuClouds.put("scattered clouds", "Рассеянные облака");
        enToRuClouds.put("broken clouds", "Облачность с просветами");
        enToRuClouds.put("overcast clouds", "Облачно");
    }

}