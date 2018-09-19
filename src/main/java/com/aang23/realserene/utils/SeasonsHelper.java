package com.aang23.realserene.utils;

import com.aang23.realserene.config.RealSereneSettings;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import sereneseasons.api.season.Season;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SeasonsHelper {
    public static class SeasonsChecker {
        //Summer checks
        public static boolean isEarlySummer() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_SUMMER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_SUMMER);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isMidSummer() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_SUMMER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_SUMMER);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isLateSummer() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_SUMMER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_SUMMER);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }

        //Autumn checks
        public static boolean isEarlyAutumn() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_AUTUMN);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_AUTUMN);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isMidAutumn() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_AUTUMN);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_AUTUMN);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isLateAutumn() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_AUTUMN);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_AUTUMN);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }

        //Winter checks
        public static boolean isEarlyWinter() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_WINTER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_WINTER);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isMidWinter() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_WINTER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_WINTER);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isLateWinter() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_WINTER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_WINTER);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }

        //Spring checks
        public static boolean isEarlySpring() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_SPRING);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_SPRING);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isMidSpring() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_SPRING);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_SPRING);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
        public static boolean isLateSpring() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_SPRING);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_SPRING);
            DayMonthDate current = getCurrentDate();
            boolean isMonth = (starting.month <= current.month) && (current.month <= ending.month); 
            boolean isDay = (starting.day <= current.day) && (current.day <= ending.day);
            return (isMonth && isDay);
        }
    }

    public static void setSeason(int dim, Season.SubSeason newSeason) {
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(minecraftServer.getWorld(dim));
        seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * newSeason.ordinal();
        seasonData.markDirty();
        SeasonHandler.sendSeasonUpdate(minecraftServer.getWorld(dim));
    }

    private static DayMonthDate getDateFromString(String input) {
        DayMonthDate toreturn = null;
        toreturn.day = Integer.parseInt(input.split("/")[0]);
        toreturn.month = Integer.parseInt(input.split("/")[1]);
        return toreturn;
    }

    private static DayMonthDate getCurrentDate() {
        DayMonthDate toreturn = null;
        toreturn.day = TimeUtils.getDay();
        toreturn.month = TimeUtils.getMonth();
        return toreturn;
    }

    private class DayMonthDate {
        int day, month;
    }
}