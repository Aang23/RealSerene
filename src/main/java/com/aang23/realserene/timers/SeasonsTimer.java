package com.aang23.realserene.timers;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import com.aang23.realserene.utils.SeasonsHelper;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.server.FMLServerHandler;
import sereneseasons.api.season.Season;

public class SeasonsTimer extends TimerTask {
    public static Season.SubSeason season;

    @Override
    public void run() {
        // Summer checking
        if (SeasonsHelper.SeasonsChecker.isEarlySummer())
            season = Season.SubSeason.EARLY_SUMMER;
        if (SeasonsHelper.SeasonsChecker.isMidSummer())
            season = Season.SubSeason.MID_SUMMER;
        if (SeasonsHelper.SeasonsChecker.isLateSummer())
            season = Season.SubSeason.LATE_SUMMER;

        // Autumn checking
        if (SeasonsHelper.SeasonsChecker.isEarlyAutumn())
            season = Season.SubSeason.EARLY_AUTUMN;
        if (SeasonsHelper.SeasonsChecker.isMidAutumn())
            season = Season.SubSeason.MID_AUTUMN;
        if (SeasonsHelper.SeasonsChecker.isLateAutumn())
            season = Season.SubSeason.LATE_AUTUMN;

        // Winter checking
        if (SeasonsHelper.SeasonsChecker.isEarlyWinter())
            season = Season.SubSeason.EARLY_WINTER;
        if (SeasonsHelper.SeasonsChecker.isMidWinter())
            season = Season.SubSeason.MID_WINTER;
        if (SeasonsHelper.SeasonsChecker.isLateWinter())
            season = Season.SubSeason.LATE_WINTER;

        // Spring checking
        if (SeasonsHelper.SeasonsChecker.isEarlySpring())
            season = Season.SubSeason.EARLY_SPRING;
        if (SeasonsHelper.SeasonsChecker.isMidSpring())
            season = Season.SubSeason.MID_SPRING;
        if (SeasonsHelper.SeasonsChecker.isLateSpring())
            season = Season.SubSeason.LATE_SPRING;

        System.out.println("The season is : " + season.toString());
    }

}