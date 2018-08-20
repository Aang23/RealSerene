package com.aang23.realserene.utils;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils
{
    public static int totalSecondTime = (24*60*60);
    
    public static int getMonth(){
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("MM");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    public static int getRawTickTime(){
        return (int)Math.round(getTimeValue()*24000);
    }

    public static double getTimeValue(){
        return ((double)getRawSeconds()/(double)totalSecondTime);
    }

    public static int getRawSeconds(){
        return (getHours()*60*60) + (getMinutes()*60) + getSeconds();
    }

    public static int getHours(){
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("HH");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    public static int getMinutes(){
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("mm");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    public static int getSeconds(){
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("ss");
        LocalDateTime time = LocalDateTime.now();
        return Integer.parseInt(hourFormat.format(time));
    }

    //Syncs the time to real since MC's time differs from real. Eg : 24000 is converted to 18000 to match midnight
    public static int syncToReal(int time){
        time -= 6000;
        if (time <= 0){
            int diff = 0 - time;
            time = 24000 - diff;
        } 
        return time;
    }
}
