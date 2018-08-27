package com.aang23.realserene.config;
import com.aang23.realserene.RealSerene;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;

@Config(modid = RealSerene.MODID)
public class RealSereneSettings {
  @Config.Comment("Enable daytime syncing")
  public static boolean realDayTime = true;

  @Config.Comment("Enable seasons syncing")
  public static boolean realSeasonsCycle = true;

  @Config.Comment("The value used to sync the day")
  public static int dayTimeSyncValue = 6000;

}