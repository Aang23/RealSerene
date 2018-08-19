package com.aang23.realserene.config;

@FunctionalInterface
public interface SettingTracker<T> {

  void update(T value);

}