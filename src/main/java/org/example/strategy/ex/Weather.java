package org.example.strategy.ex;

public enum Weather {
    SUNNY(0, "晴れ"),
    COUDY(1, "曇り"),
    RAINY(2, "雨"),
    SNOY(3, "雪");

    private final int value;
    private final String weatherName;

    Weather(int value, String weatherName) {
        this.value = value;
        this.weatherName = weatherName;
    }

    public static Weather getWeather(int value) {
        return Weather.valueOf(String.valueOf(value));
    }
}
