package com.aang23.realserene.config;
import com.aang23.realserene.RealSerene;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = RealSerene.MODID)
public class RealSereneSettings {
  @Config.Comment("Enable daytime syncing")
  public static boolean realDayTime = true;

  @Config.Comment("Enable seasons syncing")
  public static boolean realSeasonsCycle = true;

  @Config.Comment("The value used to sync the day")
  public static int dayTimeSyncValue = 6000;

  @Mod.EventBusSubscriber(modid = RealSerene.MODID)
    private static class Handler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if (event.getModID().equals(RealSerene.MODID))
            {
                ConfigManager.sync(RealSerene.MODID, Config.Type.INSTANCE);
            }
        }
    }
}