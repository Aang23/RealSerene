package com.aang23.realserene.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import com.aang23.realserene.utils.TimeUtils;


public class InfoSubCommand {
	public static void call(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length>1){
          if(args[1].equals("list")){
			sender.sendMessage(new TextComponentString("Options are : real_daytime, seconds_real_daytime, tick_daytime, tick_daytime_synced, month"));
		  } else if (args[1].equals("real_daytime")){
			sender.sendMessage(new TextComponentString("The current real daytime is : "+TimeUtils.getHours()+":"+TimeUtils.getMinutes()+":"+TimeUtils.getSeconds()));
		  } else if (args[1].equals("seconds_real_daytime")){
			sender.sendMessage(new TextComponentString("The current real seconds daytime is : "+TimeUtils.getRawSeconds()));
		  } else if (args[1].equals("tick_daytime")){
			sender.sendMessage(new TextComponentString("The current tick daytime is : "+TimeUtils.getRawTickTime()));
		  } else if (args[1].equals("synced_tick_daytime")){
			sender.sendMessage(new TextComponentString("The current synced tick daytime is : "+TimeUtils.syncToReal(TimeUtils.getRawTickTime())));
		  } else if (args[1].equals("month")){
			sender.sendMessage(new TextComponentString("The current month is : "+TimeUtils.getMonth()));
		  }
		} else sender.sendMessage(new TextComponentString("Please specify an info to query ! '/realserene info list' to get a list"));
	}
}