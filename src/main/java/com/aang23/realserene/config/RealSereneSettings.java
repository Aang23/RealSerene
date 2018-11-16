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

    @Config.Comment("Enable Vanilla weather syncing")
    public static boolean realVanillaWeatherCycle = true;

    @Config.Comment("The value used to sync the day")
    public static int dayTimeSyncValue = 6000;

    @Config.Name("Early summer starting date :")
    public static String start_EARLY_SUMMER = "21/06";
    @Config.Name("Early summer ending date :")
    public static String stop_EARLY_SUMMER = "20/07";

    @Config.Name("Mid summer starting date :")
    public static String start_MID_SUMMER = "21/07";
    @Config.Name("Mid summer ending date :")
    public static String stop_MID_SUMMER = "20/08";

    @Config.Name("Late summer starting date :")
    public static String start_LATE_SUMMER = "21/08";
    @Config.Name("Late summer ending date :")
    public static String stop_LATE_SUMMER = "21/09";

    @Config.Name("Early autumn starting date :")
    public static String start_EARLY_AUTUMN = "22/09";
    @Config.Name("Early autumn ending date :")
    public static String stop_EARLY_AUTUMN = "21/10";

    @Config.Name("Mid autumn starting date :")
    public static String start_MID_AUTUMN = "22/10";
    @Config.Name("Mid autumn ending date :")
    public static String stop_MID_AUTUMN = "21/11";

    @Config.Name("Late autumn starting date :")
    public static String start_LATE_AUTUMN = "22/11";
    @Config.Name("Late autumn ending date :")
    public static String stop_LATE_AUTUMN = "20/12";

    @Config.Name("Early winter starting date :")
    public static String start_EARLY_WINTER = "21/12";
    @Config.Name("Early winter ending date :")
    public static String stop_EARLY_WINTER = "20/01";

    @Config.Name("Mid winter starting date :")
    public static String start_MID_WINTER = "21/01";
    @Config.Name("Mid winter ending date :")
    public static String stop_MID_WINTER = "20/02";

    @Config.Name("Late winter starting date :")
    public static String start_LATE_WINTER = "21/02";
    @Config.Name("Late winter ending date :")
    public static String stop_LATE_WINTER = "19/3";

    @Config.Name("Early spring starting date :")
    public static String start_EARLY_SPRING = "20/03";
    @Config.Name("Early spring ending date :")
    public static String stop_EARLY_SPRING = "19/04";

    @Config.Name("Mid spring starting date :")
    public static String start_MID_SPRING = "20/04";
    @Config.Name("Mid spring ending date :")
    public static String stop_MID_SPRING = "19/05";

    @Config.Name("Late spring starting date :")
    public static String start_LATE_SPRING = "20/05";
    @Config.Name("Late spring ending date :")
    public static String stop_LATE_SPRING = "20/06";

    @Config.Name("OpenWeatherMap API Key")
    public static String opm_api_key = "";

    @Config.Name("OpenWeatherMap City Name")
    public static String opm_city_name = "";

    @Config.Name("OpenWeatherMap Country Name")
    public static String opm_country_code = "";

    @Config.Comment("RealVanillaWeatherSync Update Timing")
    public static int real_vanilla_weather_timing = 5*60000;

    @Config.Comment("Time shift (positive or negative), from the local machine's time (Hours)")
    public static int timeShift = 0;

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