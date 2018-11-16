package com.aang23.realserene.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import com.aang23.realserene.external.*;


public class GetWSubCommand {
	public static void call(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length>2){
            sender.sendMessage(new TextComponentString(WeatherGetter.getWeather(args[1], args[2])));
		} else sender.sendMessage(new TextComponentString("Usage : /realserene getw [city] [countrycode]"));
	}
}