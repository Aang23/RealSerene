package com.aang23.realserene.timers;

import java.util.TimerTask;
import com.aang23.realserene.utils.WeatherUtils;

public class WeatherTimer extends TimerTask {

    @Override
    public void run() {

        WeatherUtils.setWeather();
        //System.out.println("Changing the weather");

    }

}