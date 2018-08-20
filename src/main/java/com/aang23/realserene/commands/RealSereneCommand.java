package com.aang23.realserene.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;


public class RealSereneCommand extends CommandBase {
	
	@Override
	public String getName()
	{
	return "realserene";
	}

	@Override
	public String getUsage(ICommandSender icommandsender)
	{
	return "Usage : /realserene <info>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length>0){
        if(args[0].equals("info")) InfoSubCommand.call(server, sender, args);
        else sender.sendMessage(new TextComponentString("Usage : /realserene <info>"));
        } else sender.sendMessage(new TextComponentString("Usage : /realserene <info>"));
	}
}

