package com.aang23.realserene.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.external.openweathermap.*;


public class GetWSubCommand {
	public static void call(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length==3){
            sender.sendMessage(new TextComponentString(WeatherGetter.getWeather(args[1], args[2])));
		} else if(args.length==1){
            sender.sendMessage(new TextComponentString(WeatherGetter.getWeather(RealSereneSettings.opm_city_name,RealSereneSettings.opm_country_code)));
		} else sender.sendMessage(new TextComponentString("Usage : /realserene getw [city] [countrycode]"));
	}
}