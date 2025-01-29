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
            case "Thunderstorm" -> weatherTranslate.enToRuThunderstorm.get(description);
            case "Drizzle" -> weatherTranslate.enToRuDrizzle.get(description);
            case "Snow" -> weatherTranslate.enToRuSnow.get(description);
            case "Rain" -> weatherTranslate.enToRuRain.get(description);
            case "Atmosphere" -> weatherTranslate.enToRuAtmosphere.get(description);
            case "Clear" -> weatherTranslate.enToRuClear.get(description);
            case "Clouds" -> weatherTranslate.enToRuClouds.get(description);
            default -> "";
        };
    }
}
