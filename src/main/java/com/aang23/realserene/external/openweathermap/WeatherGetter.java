package com.aang23.realserene.external.openweathermap;

import com.aang23.realserene.config.RealSereneSettings;

import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.*;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

public class WeatherGetter {
  public static String getWeather(String city, String country) {
    DataWeatherClient client = new UrlConnectionDataWeatherClient(RealSereneSettings.opm_api_key);
    CurrentWeatherOneLocationQuery currentWeatherOneLocationQuery = QueryBuilderPicker.pick().currentWeather() // get
                                                                                                               // current
                                                                                                               // weather
        .oneLocation() // for one location
        .byCityName(city) // for Kharkiv city
        .countryCode(country) // in Ukraine
        .type(Type.ACCURATE) // with Accurate search
        .language(Language.ENGLISH) // in English language
        .responseFormat(ResponseFormat.JSON)// with JSON response format
        .unitFormat(UnitFormat.METRIC) // in metric units
        .build();
    CurrentWeather currentWeather = client.getCurrentWeather(currentWeatherOneLocationQuery);
    return currentWeather.getWeather().toString();
  }
}