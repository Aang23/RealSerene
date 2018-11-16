package com.aang23.realserene.intermod.weather2;

import weather2.api.*;
import weather2.weathersystem.*;

public class Integration {
    public static WeatherManagerBase weatherManager;

    public static void init() {
        weatherManager = WeatherDataHelper.getWeatherManagerForClient();
    }
}