package org.example.strategy.ex;

public enum Weather {
    SUNNY(0, "晴れ"),
    COUDY(1, "曇り"),
    RAINY(2, "雨"),
    SNOY(3, "雪");

    Weather(int value, String weatherName) {
    }

    public static Weather getWeather(int value) {
        return Weather.valueOf(String.valueOf(value));
    }
}
