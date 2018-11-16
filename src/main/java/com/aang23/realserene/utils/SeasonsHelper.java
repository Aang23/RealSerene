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
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_SUMMER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_SUMMER);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isMidSummer() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_SUMMER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_SUMMER);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isLateSummer() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_SUMMER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_SUMMER);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        // Autumn checks
        public static boolean isEarlyAutumn() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_AUTUMN);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_AUTUMN);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isMidAutumn() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_AUTUMN);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_AUTUMN);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isLateAutumn() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_AUTUMN);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_AUTUMN);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        // Winter checks
        public static boolean isEarlyWinter() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_WINTER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_WINTER);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isMidWinter() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_WINTER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_WINTER);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isLateWinter() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_WINTER);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_WINTER);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        // Spring checks
        public static boolean isEarlySpring() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_EARLY_SPRING);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_EARLY_SPRING);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isMidSpring() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_MID_SPRING);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_MID_SPRING);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
        }

        public static boolean isLateSpring() {
            DayMonthDate starting = getDateFromString(RealSereneSettings.start_LATE_SPRING);
            DayMonthDate ending = getDateFromString(RealSereneSettings.stop_LATE_SPRING);
            DayMonthDate current = getCurrentDate();
            DateTime currentDate = new DateTime(new java.util.Date()).withMonthOfYear(current.month).withDayOfMonth(current.day);
            DateTime startingDate = new DateTime(new java.util.Date()).withMonthOfYear(starting.month).withDayOfMonth(starting.day);
            DateTime endingDate = new DateTime(new java.util.Date()).withMonthOfYear(ending.month).withDayOfMonth(ending.day);
            return currentDate.isAfter(startingDate) && currentDate.isBefore(endingDate);
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
        DayMonthDate toreturn = new DayMonthDate();
        toreturn.day = Integer.parseInt(input.split("/")[0]);
        toreturn.month = Integer.parseInt(input.split("/")[1]);
        return toreturn;
    }

    private static DayMonthDate getCurrentDate() {
        DayMonthDate toreturn = new DayMonthDate();
        toreturn.day = TimeUtils.getDay();
        toreturn.month = TimeUtils.getMonth();
        return toreturn;
    }
}