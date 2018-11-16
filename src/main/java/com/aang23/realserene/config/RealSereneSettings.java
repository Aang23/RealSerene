package com.aang23.realserene.config;

import com.aang23.realserene.RealSerene;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = RealSerene.MODID)
public class RealSereneSettings {
    @Config.Comment("Enable daytime syncing")
    @Config.RequiresWorldRestart
    public static boolean realDayTime = true;

    @Config.Comment("Enable seasons syncing")
    public static boolean realSeasonsCycle = true;

    @Config.Comment("The value used to sync the day")
    public static int dayTimeSyncValue = 6000;

    @Config.Name("Early summer starting date :")
    public static String start_EARLY_SUMMER = "21/06";
    @Config.Name("Early summer ending date :")
    public static String stop_EARLY_SUMMER = "xx/xx";

    @Config.Name("Mid summer starting date :")
    public static String start_MID_SUMMER = "xx/xx";
    @Config.Name("Mid summer ending date :")
    public static String stop_MID_SUMMER = "xx/xx";

    @Config.Name("Late summer starting date :")
    public static String start_LATE_SUMMER = "xx/xx";
    @Config.Name("Late summer ending date :")
    public static String stop_LATE_SUMMER = "21/09";

    @Config.Name("Early autumn starting date :")
    public static String start_EARLY_AUTUMN = "22/09";
    @Config.Name("Early autumn ending date :")
    public static String stop_EARLY_AUTUMN = "xx/xx";

    @Config.Name("Mid autumn starting date :")
    public static String start_MID_AUTUMN = "xx/xx";
    @Config.Name("Mid autumn ending date :")
    public static String stop_MID_AUTUMN = "xx/xx";

    @Config.Name("Late autumn starting date :")
    public static String start_LATE_AUTUMN = "xx/xx";
    @Config.Name("Late autumn ending date :")
    public static String stop_LATE_AUTUMN = "20/12";

    @Config.Name("Early winter starting date :")
    public static String start_EARLY_WINTER = "21/12";
    @Config.Name("Early winter ending date :")
    public static String stop_EARLY_WINTER = "xx/xx";

    @Config.Name("Mid winter starting date :")
    public static String start_MID_WINTER = "xx/xx";
    @Config.Name("Mid winter ending date :")
    public static String stop_MID_WINTER = "xx/xx";

    @Config.Name("Late winter starting date :")
    public static String start_LATE_WINTER = "xx/xx";
    @Config.Name("Late winter ending date :")
    public static String stop_LATE_WINTER = "19/3";

    @Config.Name("Early spring starting date :")
    public static String start_EARLY_SPRING = "20/03";
    @Config.Name("Early spring ending date :")
    public static String stop_EARLY_SPRING = "xx/xx";

    @Config.Name("Mid spring starting date :")
    public static String start_MID_SPRING = "xx/xx";
    @Config.Name("Mid spring ending date :")
    public static String stop_MID_SPRING = "xx/xx";

    @Config.Name("Late spring starting date :")
    public static String start_LATE_SPRING = "xx/xx";
    @Config.Name("Late spring ending date :")
    public static String stop_LATE_SPRING = "20/06";

    @Config.Name("OpenWeatherMap API Key")
    public static String opm_api_key = "";

    @Mod.EventBusSubscriber(modid = RealSerene.MODID)
    private static class Handler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(RealSerene.MODID)) {
                ConfigManager.sync(RealSerene.MODID, Config.Type.INSTANCE);
            }
        }
    }
}