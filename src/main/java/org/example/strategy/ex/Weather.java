package org.example.strategy.ex;

public enum Weather {
    SUNNY(),
    COUDY(),
    RAINY(),
    SNOY();

    Weather() {
    }

    public static Weather getWeather(int value) {
        return Weather.valueOf(String.valueOf(value));
    }
}
