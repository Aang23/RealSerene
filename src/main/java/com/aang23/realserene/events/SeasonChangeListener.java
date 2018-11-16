package com.aang23.realserene.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.timers.SeasonsTimer;
import com.aang23.realserene.utils.SeasonsHelper;

public class SeasonChangeListener {
    @SubscribeEvent
    public void onTick(TickEvent.WorldTickEvent event) {
        if (RealSereneSettings.realSeasonsCycle) {
            SeasonsHelper.setSeason(0, SeasonsTimer.season);
        }
    }
}
