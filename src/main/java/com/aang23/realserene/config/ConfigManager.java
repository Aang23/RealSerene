package com.aang23.realserene.config;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ConfigManager {
  private File generalConfigFile;
  public RealSereneConfig generalSettings;

  public ConfigManager(FMLPreInitializationEvent event) {
    this(new RealSereneConfig(),
      event.getSuggestedConfigurationFile());
  }

  public ConfigManager(RealSereneConfig settings, File generalFile) {
    this.generalConfigFile = generalFile;
    generalSettings = new RealSereneConfig();
    generalSettings.init(generalConfigFile);
  }
}