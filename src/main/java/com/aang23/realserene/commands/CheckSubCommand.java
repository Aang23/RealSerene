package com.aang23.realserene.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import com.aang23.realserene.timers.SeasonsTimer;
import com.aang23.realserene.utils.TimeUtils;


public class CheckSubCommand {
	public static void call(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args.length>1){
          if(args[1].equals("list")){
              sender.sendMessage(new TextComponentString("Available checks : sync"));
          } else if(args[1].equals("sync")){
			sender.sendMessage(new TextComponentString(Integer.toString(TimeUtils.syncToReal(Integer.parseInt(args[2])))));
		  } else if(args[1].equals("seasonsync")){
			SeasonsTimer.runOnce();
			sender.sendMessage(new TextComponentString("Synced the season"));
		  } 
		} else sender.sendMessage(new TextComponentString("Please specify an check to do ! '/realserene check list' for a list. Usage : /realserene check [check] [args]"));
	}
}