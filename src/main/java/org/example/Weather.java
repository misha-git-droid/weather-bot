package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Weather {

    private String main;
    private String description;

    public String toString() {
        return "Основная информация: " + main + "\n" + "Описание: " + description;
    }
}




