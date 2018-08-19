package com.aang23.realserene.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TickEventListener
{
    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event)
    {
        //Generates the date
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter minuteFormat = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter secondFormat = DateTimeFormatter.ofPattern("ss");
        LocalDateTime time = LocalDateTime.now();

        //Get it to ints
        int hours = Integer.parseInt(hourFormat.format(time));
        int minutes = Integer.parseInt(minuteFormat.format(time));
        int seconds = Integer.parseInt(secondFormat.format(time));

        //Convert it into raw seconds
        int currentSecondTime = (hours*60*60) + (minutes*60) + seconds;
        int totalSecondTime = (24*60*60);

        //Get the fraction value
        double timeValue = ((double)currentSecondTime/(double)totalSecondTime);

        //Sync and apply it to the world
        event.world.setWorldTime(syncToReal((int)Math.round(timeValue*24000))); //24000 
    }

    //Syncs the time to real since MC's time differs from real. Eg : 24000 is converted to 18000 to match midnight
    public int syncToReal(int time){
        time -= 6000;
        if (time < 0){
            int diff = 0 - time;
            time = 24000 - diff;
        } 
        return time;
    }
}
