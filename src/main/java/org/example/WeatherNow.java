package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WeatherNow {
    private List<Weather> weather;
    private Main main;

    @Override
    public String toString() {
        Weather objWeather = null;
        for (Weather data : weather) {
            objWeather = data;
        }
        return objWeather + "\n" + main.toString();
    }


}
