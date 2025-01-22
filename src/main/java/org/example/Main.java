package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Main {
    private int temp;
    @JsonProperty("feels_like")
    private int fellsLike;

    @Override
    public String toString() {
        return "Температура: " + temp + "\nОщущается как: " + fellsLike;
    }
}
