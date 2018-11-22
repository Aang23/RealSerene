package com.aang23.realserene.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.intermod.sereneseasons.SereneIntegration;
import com.aang23.realserene.timers.SeasonsTimer;

public class SeasonChangeListener {
    @SubscribeEvent
    public void onTick(TickEvent.WorldTickEvent event) {
        if (RealSereneSettings.realSeasonsCycle) {
            try{
            SereneIntegration.setSeason(0, SeasonsTimer.season);
            } catch (NullPointerException e){
                System.out.println("Season not set. Calculating.");
                SeasonsTimer.runOnce();
            }
        }
    }
}
