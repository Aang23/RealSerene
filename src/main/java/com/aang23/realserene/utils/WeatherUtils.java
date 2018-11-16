package com.aang23.realserene.utils;

import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.external.openweathermap.WeatherGetter;

public class WeatherUtils {
    public static boolean raining = false;
    public static boolean thundering = false;

    public static void setWeather() {
        if (WeatherGetter.getWeather(RealSereneSettings.opm_city_name, RealSereneSettings.opm_country_code)
                .contains("Rain") || WeatherGetter.getWeather(RealSereneSettings.opm_city_name, RealSereneSettings.opm_country_code).contains("Snow")) {
            raining = true;
        } else {
            raining = false;
        }
    }
}
