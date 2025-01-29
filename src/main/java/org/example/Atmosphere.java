package org.example;

import java.util.ArrayList;
import java.util.List;

public class Atmosphere {

    List<String> atmosphereList = new ArrayList<>();

    public Atmosphere() {
        this.init();
    }

    public void init() {
        atmosphereList.add("Mist");
        atmosphereList.add("Smoke");
        atmosphereList.add("Haze");
        atmosphereList.add("Dust");
        atmosphereList.add("Fog");
        atmosphereList.add("Sand");
        atmosphereList.add("Ash");
        atmosphereList.add("Squall");
        atmosphereList.add("Tornado");
    }
}
