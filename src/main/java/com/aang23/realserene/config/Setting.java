package com.aang23.realserene.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import java.util.ArrayList;
import java.util.List;

abstract class Setting<T> {

  protected final String category;
  protected final String key;
  protected final List<SettingTracker<T>> trackers = new ArrayList<>();
  protected final List<SettingOverride<T, ?>> overrides = new ArrayList<>();
  protected Property property;

  public Setting(String category, String key) {
    this.category = category;
    this.key = key;
  }

  public void initProperty(Configuration configuration, T defaultValue, String comment) {
    System.out.println("Creating property " + key + " with default value " + defaultValue);
    createProperty(configuration, defaultValue, comment);
    System.out.println("Property " + key + " initialized with value " + getValue());
  }

  protected abstract void createProperty(Configuration configuration, T defaultValue, String comment);

  public final void changeValue(T value) {
    System.out.println("Changing value of property " + key + ", previous value: " + getValue());
    setValue(value);
    System.out.println("Property " + key + ": value changed to " + value);
    overrides.forEach((setting) -> setting.apply());
    trackers.forEach(tracker -> tracker.update(value));
  }

  protected abstract void setValue(T value);

  public abstract T getValue();

  public final void addTracker(SettingTracker<T> tracker) {
    System.out.println("Adding tracker to property " + key);
    trackers.add(tracker);
  }

  public final void addTrackerAndUpdate(SettingTracker<T> tracker) {
    System.out.println("Adding tracker to property " + key);
    trackers.add(tracker);
    tracker.update(getValue());
  }

  public final <U> Setting<T> addOverride(T condition, Setting<U> setting, U forcedValue) {
    System.out.println("Adding override to property " + key);
    System.out.println("If value == " + condition + " -> " + setting.key + " = " + forcedValue);
    overrides.add(new SettingOverride<>(this, condition, setting, forcedValue));
    if (valueEquals(condition))
      setting.setValue(forcedValue);
    return this;
  }

  protected abstract boolean valueEquals(T condition);

}