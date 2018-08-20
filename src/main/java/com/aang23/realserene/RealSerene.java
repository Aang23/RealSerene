package com.aang23.realserene;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import com.aang23.realserene.events.SeasonChangeListener;
import com.aang23.realserene.utils.TimeUtils;
import com.aang23.realserene.events.DaytimeChangeListener;
import com.aang23.realserene.config.ConfigManager;
import com.aang23.realserene.commands.RealSereneCommand;


@Mod(modid = RealSerene.MODID, name = RealSerene.NAME, version = RealSerene.VERSION)
public class RealSerene
{
    public static final String MODID = "realserene";
    public static final String NAME = "Real Serene Seasons";
    public static final String VERSION = "1.2";

    public static ConfigManager configManager;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("Initializing RealSerene...");
        configManager = new ConfigManager(event);    
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("Starting RealSerene...");
        //Register the handler for daytime
        if(configManager.generalSettings.realDayTime()){
            System.out.println("Registering event for RealDayTime...");
            MinecraftForge.EVENT_BUS.register(new DaytimeChangeListener());
        } else {
            System.out.println("Skipping event for RealDayTime...");
        }
        if(configManager.generalSettings.realSeasonsCycle()){
            System.out.println("Registering event for RealSeasonsCycle...");
            MinecraftForge.EVENT_BUS.register(new SeasonChangeListener());
        } else {
            System.out.println("Skipping event for RealSeasonsCycle...");
        }
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new RealSereneCommand());
    }

    @EventHandler
    public void serverStarted(FMLServerStartedEvent event)
    {
        //Set the gamerule to prevent the sun from glitching out sometimes.
        MinecraftServer minecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        minecraftServer.getWorld(0).getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
        TimeUtils.syncValue = configManager.generalSettings.dayTimeSyncValue.getValue();
    }
}
