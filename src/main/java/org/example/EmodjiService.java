package org.example;

public class EmodjiService {

    Emodji emodji;

    public EmodjiService(Emodji emodji) {
        this.emodji = emodji;
    }

    public String getEmodji(WeatherNow wN) {

        Weather weather = wN.getWeather().get(0);
        String main = weather.getMain();
        String description = weather.getDescription();

        return switch (main) {
            case "Thunderstorm" -> emodji.emodjiThunderstorm.get(description);
            case "Drizzle" -> emodji.emodjiDrizzle.get(description);
            case "Snow" -> emodji.emodjiSnow.get(description);
            case "Rain" -> emodji.emodjiRain.get(description);
            case "Atmosphere" -> emodji.emodjiAtmosphere.get(description);
            case "Clear" -> emodji.emodjiClear.get(description);
            case "Clouds" -> emodji.emodjiClouds.get(description);
            default -> "";
        };
    }
}
