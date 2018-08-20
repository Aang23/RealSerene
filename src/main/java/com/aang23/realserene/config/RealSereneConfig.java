package com.aang23.realserene.config;

import net.minecraftforge.common.config.Configuration;
import com.aang23.realserene.config.RealSereneSettings;
import java.io.File;



public class RealSereneConfig implements RealSereneSettings {
  public static RealSereneSettings SPECIFIC;


  private Configuration configuration;

  private static final String CATEGORY_GENERAL = "General";
  public final BooleanSetting realDayTime = new BooleanSetting(CATEGORY_GENERAL, "RealDayTime");
  public final BooleanSetting realSeasonsCycle = new BooleanSetting(CATEGORY_GENERAL, "RealSeasonsCycle");
  public final IntegerSetting dayTimeSyncValue = new IntegerSetting(CATEGORY_GENERAL, "DayTimeSyncValue");

  
  public void init(File file) {

    configuration = new Configuration(file);
    configuration.load();

    realDayTime.initProperty(configuration, true, "Sync the time to correspond to the real one.");
    realSeasonsCycle.initProperty(configuration, true, "Sync seasons to correspond to the reals ones.");
    dayTimeSyncValue.initProperty(configuration, 6000, "The value (in ticks) to correct the in-game cycle with the real one. Useful if you want, for example, to invert day / night, or anything else.");

    configuration.save();
  }

  public void copy(RealSereneConfig copied) {
    realDayTime.setValue(copied.realDayTime.getValue());
    realSeasonsCycle.setValue(copied.realSeasonsCycle.getValue());
    dayTimeSyncValue.setValue(copied.dayTimeSyncValue.getValue());
  }

  public void save() {
    configuration.save();
  }

  @Override
  public boolean realDayTime() {
    return realDayTime.getValue();
  }

  @Override
  public boolean realSeasonsCycle() {
    return realSeasonsCycle.getValue();
  }

  @Override
  public int dayTimeSyncValue(){
    return dayTimeSyncValue.getValue();
  }
}