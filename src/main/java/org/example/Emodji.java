package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Emodji {

    HashMap<String, String> emodjiSnow = new HashMap<>();
    HashMap<String, String> emodjiRain = new HashMap<>();
    HashMap<String, String> emodjiThunderstorm = new HashMap<>();
    HashMap<String, String> emodjiDrizzle = new HashMap<>();
    HashMap<String, String> emodjiAtmosphere = new HashMap<>();
    HashMap<String, String> emodjiClear = new HashMap<>();
    HashMap<String, String> emodjiClouds = new HashMap<>();

    public Emodji() {
        this.init();
    }

    public void init() {
        emodjiSnow.put("light snow", ":cloud_snow:");
        emodjiSnow.put("snow", ":cloud_snow:");
        emodjiSnow.put("heavy snow", ":cloud_snow:");
        emodjiSnow.put("sleet", ":cloud_snow:");
        emodjiSnow.put("light shower sleet", ":cloud_snow:");
        emodjiSnow.put("shower sleet", ":cloud_snow:");
        emodjiSnow.put("light rain and snow", ":cloud_snow:");
        emodjiSnow.put("rain and snow", ":cloud_snow:");
        emodjiSnow.put("light shower snow", ":cloud_snow:");
        emodjiSnow.put("shower snow", ":cloud_snow:");
        emodjiSnow.put("heavy shower snow", ":cloud_snow:");
        //
        emodjiRain.put("light rain", ":white_sun_behind_cloud_rain:");
        emodjiRain.put("moderate rain", ":white_sun_behind_cloud_rain:");
        emodjiRain.put("heavy intensity rain", ":white_sun_behind_cloud_rain:");
        emodjiRain.put("very heavy rain", ":white_sun_behind_cloud_rain:");
        emodjiRain.put("extreme rain", ":white_sun_behind_cloud_rain:");
        emodjiRain.put("freezing rain", "cloud_rain");
        emodjiRain.put("light intensity shower rain", "cloud_rain");
        emodjiRain.put("shower rain", "cloud_rain");
        emodjiRain.put("heavy intensity shower rain", "cloud_rain");
        emodjiRain.put("ragged shower rain", "cloud_rain");
        //
        emodjiThunderstorm.put("thunderstorm with light rain", ":thunder_cloud_rain:");
        emodjiThunderstorm.put("thunderstorm with rain", ":thunder_cloud_rain:");
        emodjiThunderstorm.put("thunderstorm with heavy rain", ":thunder_cloud_rain:");
        emodjiThunderstorm.put("light thunderstorm", ":cloud_lightning:");
        emodjiThunderstorm.put("thunderstorm", ":cloud_lightning:");
        emodjiThunderstorm.put("heavy thunderstorm", ":cloud_lightning:");
        emodjiThunderstorm.put("ragged thunderstorm", ":cloud_lightning:");
        emodjiThunderstorm.put("thunderstorm with light drizzle", ":thunder_cloud_rain:");
        emodjiThunderstorm.put("thunderstorm with drizzle", ":thunder_cloud_rain:");
        emodjiThunderstorm.put("thunderstorm with heavy drizzle", ":thunder_cloud_rain:");
        //
        emodjiDrizzle.put("light intensity drizzle", ":droplet:");
        emodjiDrizzle.put("drizzle", ":droplet:");
        emodjiDrizzle.put("heavy intensity drizzle", ":droplet:");
        emodjiDrizzle.put("light intensity drizzle rain", ":droplet:");
        emodjiDrizzle.put("drizzle rain", ":droplet:");
        emodjiDrizzle.put("heavy intensity drizzle rain", ":droplet:");
        emodjiDrizzle.put("shower rain and drizzle", ":droplet:");
        emodjiDrizzle.put("heavy shower rain and drizzle", ":droplet:");
        emodjiDrizzle.put("shower drizzle", ":droplet:");
        //
        emodjiAtmosphere.put("mist", ":fog:");
        emodjiAtmosphere.put("smoke", ":fog:");
        emodjiAtmosphere.put("haze", ":fog:");
        emodjiAtmosphere.put("sand/dust whirls", ":fog:");
        emodjiAtmosphere.put("fog", ":fog:");
        emodjiAtmosphere.put("sand", ":fog:");
        emodjiAtmosphere.put("dust", ":fog:");
        emodjiAtmosphere.put("volcanic ash", ":fog:");
        emodjiAtmosphere.put("squalls", ":fog:");
        emodjiAtmosphere.put("tornado", ":cloud_tornado:");
        //
        emodjiClear.put("clear sky", ":sunny:");
        //
        emodjiClouds.put("few clouds", ":white_sun_small_cloud:");
        emodjiClouds.put("scattered clouds", ":partly_sunny:");
        emodjiClouds.put("broken clouds", ":white_sun_behind_cloud:");
        emodjiClouds.put("overcast clouds", ":cloud:");
    }
}
