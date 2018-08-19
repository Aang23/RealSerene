package com.aang23.realserene.config;

public final class SettingOverride<T, U> {

  private final Setting<T> condition;
  private final T conditionValue;
  private final Setting<U> forced;
  private final U forcedValue;

  public SettingOverride(Setting<T> condition, T conditionValue, Setting<U> forced, U forcedValue) {
    this.condition = condition;
    this.conditionValue = conditionValue;
    this.forced = forced;
    this.forcedValue = forcedValue;
  }

  public void apply() {
    if (condition.valueEquals(conditionValue))
      forced.changeValue(forcedValue);
  }

}