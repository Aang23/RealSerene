package com.aang23.realserene.events;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import sereneseasons.api.season.Season;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SeasonChangeListener
{
    @SubscribeEvent
    public void onTick(TickEvent.WorldTickEvent event)
    {
        //Format the date
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("MM");
        LocalDateTime time = LocalDateTime.now();

        //Get the current month
        int month = Integer.parseInt(hourFormat.format(time));

        //Set the current month
        switch(month){
            case 1: setSeason(0, Season.SubSeason.MID_WINTER); break;
            case 2: setSeason(0, Season.SubSeason.LATE_WINTER); break;
            case 3: setSeason(0, Season.SubSeason.EARLY_SPRING); break;
            case 4: setSeason(0, Season.SubSeason.MID_SPRING); break;
            case 5: setSeason(0, Season.SubSeason.LATE_SPRING); break;
            case 6: setSeason(0, Season.SubSeason.EARLY_SUMMER); break;
            case 7: setSeason(0, Season.SubSeason.MID_SUMMER); break;
            case 8: setSeason(0, Season.SubSeason.LATE_SUMMER); break;
            case 9: setSeason(0, Season.SubSeason.EARLY_AUTUMN); break;
            case 10: setSeason(0, Season.SubSeason.MID_AUTUMN); break;
            case 11: setSeason(0, Season.SubSeason.LATE_AUTUMN); break;
            case 12: setSeason(0, Season.SubSeason.EARLY_WINTER); break;
        }
    }

    public static void setSeason(int dim, Season.SubSeason newSeason) 
    {
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();

        SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(minecraftServer.getWorld(dim));
        seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * newSeason.ordinal();
        seasonData.markDirty();
        SeasonHandler.sendSeasonUpdate(minecraftServer.getWorld(dim));
    }

}
