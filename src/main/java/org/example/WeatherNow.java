package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class WeatherNow {

    private List<Weather> weather;
    private Main main;

}
