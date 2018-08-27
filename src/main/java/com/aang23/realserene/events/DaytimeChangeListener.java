package com.aang23.realserene.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import com.aang23.realserene.utils.TimeUtils;
import com.aang23.realserene.config.RealSereneSettings;

public class DaytimeChangeListener
{
    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event)
    {
        if(RealSereneSettings.realDayTime){
        event.world.setWorldTime(TimeUtils.syncToReal(TimeUtils.getRawTickTime())); //24000 
        }
    }
}
