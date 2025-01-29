package org.example;

public class AtmosphereService {

    Atmosphere atmosphere;

    public AtmosphereService(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public void checkWeatherMain(WeatherNow weatherNow) {
        Weather weather = weatherNow.getWeather().get(0);
        if (atmosphere.atmosphereList.contains(weather.getMain())) {
           weather.setMain("Atmosphere");
        }
    }

}
