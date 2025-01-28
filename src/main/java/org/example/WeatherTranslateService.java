package org.example;

public class WeatherTranslateService {

    WeatherTranslate weatherTranslate;

    public WeatherTranslateService(WeatherTranslate weatherTranslate) {
        this.weatherTranslate = weatherTranslate;
    }

    public String getTranslate(WeatherNow weatherNow) {

        Weather weather = weatherNow.getWeather().get(0);
        String description = weather.getDescription();
        String main = weather.getMain();

        return switch (main) {
            case "Thunderstorm" -> enToRuThunderstorm.get(description);
            case "Drizzle" -> enToRuDrizzle.get(description);
            case "Snow" -> enToRuSnow.get(description);
            case "Rain" -> enToRuRain.get(description);
            case "Atmosphere" -> enToRuAtmosphere.get(description);
            case "Clear" -> enToRuClear.get(description);
            case "Clouds" -> enToRuClouds.get(description);
            default -> "";
        };
    }
}
