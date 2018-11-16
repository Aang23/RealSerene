package com.aang23.realserene.external;

import org.openweathermap.api.DataWeatherClient;
import org.openweathermap.api.UrlConnectionDataWeatherClient;
import org.openweathermap.api.model.currentweather.CurrentWeather;
import org.openweathermap.api.query.*;
import org.openweathermap.api.query.currentweather.CurrentWeatherOneLocationQuery;

public class WeatherGetter {
  public static String getWeather() {
    DataWeatherClient client = new UrlConnectionDataWeatherClient("You won't get that !");
    CurrentWeatherOneLocationQuery currentWeatherOneLocationQuery = QueryBuilderPicker.pick().currentWeather() // get
                                                                                                               // current
                                                                                                               // weather
        .oneLocation() // for one location
        .byCityName("Paris") // for Kharkiv city
        .countryCode("FR") // in Ukraine
        .type(Type.ACCURATE) // with Accurate search
        .language(Language.ENGLISH) // in English language
        .responseFormat(ResponseFormat.JSON)// with JSON response format
        .unitFormat(UnitFormat.METRIC) // in metric units
        .build();
    CurrentWeather currentWeather = client.getCurrentWeather(currentWeatherOneLocationQuery);
    System.out.println(currentWeather.getWeather());
    return "working";
  }
}