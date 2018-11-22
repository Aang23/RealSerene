package com.aang23.realserene.intermod.sereneseasons;

import net.minecraft.server.MinecraftServer;
import sereneseasons.api.season.Season;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SereneIntegration {
    public static void setSeason(int dim, Season.SubSeason newSeason) {
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(minecraftServer.getWorld(dim));
        seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * newSeason.ordinal();
        seasonData.markDirty();
        SeasonHandler.sendSeasonUpdate(minecraftServer.getWorld(dim));
    }
}