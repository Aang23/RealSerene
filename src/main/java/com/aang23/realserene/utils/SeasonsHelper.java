package com.aang23.realserene.utils;

import com.aang23.realserene.config.RealSereneSettings;

import net.minecraft.server.MinecraftServer;
import sereneseasons.api.season.Season;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.joda.time.DateTime;

public class SeasonsHelper {
    public static class SeasonsChecker {
        // Summer checks
        public static boolean isEarlySummer() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_SUMMER);
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_SUMMER);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidSummer() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_SUMMER);
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_SUMMER);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateSummer() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_SUMMER);
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_SUMMER);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        // Autumn checks
        public static boolean isEarlyAutumn() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_AUTUMN);
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_AUTUMN);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidAutumn() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_AUTUMN);
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_AUTUMN);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateAutumn() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_AUTUMN);
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_AUTUMN);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        // Winter checks
        public static boolean isEarlyWinter() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_WINTER);
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_WINTER);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidWinter() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_WINTER);
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_WINTER);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateWinter() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_WINTER);
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_WINTER);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        // Spring checks
        public static boolean isEarlySpring() {
            DateTime starting = getDateFromString(RealSereneSettings.start_EARLY_SPRING);
            DateTime ending = getDateFromString(RealSereneSettings.stop_EARLY_SPRING);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isMidSpring() {
            DateTime starting = getDateFromString(RealSereneSettings.start_MID_SPRING);
            DateTime ending = getDateFromString(RealSereneSettings.stop_MID_SPRING);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }

        public static boolean isLateSpring() {
            DateTime starting = getDateFromString(RealSereneSettings.start_LATE_SPRING);
            DateTime ending = getDateFromString(RealSereneSettings.stop_LATE_SPRING);
            DateTime current = getCurrentDate();
            return (current.isAfter(starting) && current.isBefore(ending)) || (current.isEqual(starting) || current.isEqual(ending));
        }
    }

    public static void setSeason(int dim, Season.SubSeason newSeason) {
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(minecraftServer.getWorld(dim));
        seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * newSeason.ordinal();
        seasonData.markDirty();
        SeasonHandler.sendSeasonUpdate(minecraftServer.getWorld(dim));
    }

    private static DateTime getDateFromString(String input) {
        DateTime toreturn = new DateTime().withDayOfMonth(Integer.parseInt(input.split("/")[0])).withMonthOfYear(Integer.parseInt(input.split("/")[1])).withYear(TimeUtils.getYear());
        return toreturn;
    }

    private static DateTime getCurrentDate() {
        DateTime toreturn = new DateTime().withDayOfMonth(TimeUtils.getDay()).withMonthOfYear(TimeUtils.getMonth()).withYear(TimeUtils.getYear());
        return toreturn;
    }
}