package com.aang23.realserene.events;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import sereneseasons.api.season.Season;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import net.minecraftforge.fml.common.FMLCommonHandler;

import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.timers.SeasonsTimer;
import com.aang23.realserene.utils.TimeUtils;
import com.aang23.realserene.utils.SeasonsHelper;

public class SeasonChangeListener {
    @SubscribeEvent
    public void onTick(TickEvent.WorldTickEvent event) {
        if (RealSereneSettings.realSeasonsCycle) {
            SeasonsHelper.setSeason(0, SeasonsTimer.season);
        }
    }
}
