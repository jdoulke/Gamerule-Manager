package me.ted2001.gamerulesmanager;

import me.ted2001.gamerulesmanager.Commands.GuiCommand;
import me.ted2001.gamerulesmanager.Listeners.GuiListener;
import me.ted2001.gamerulesmanager.Listeners.UpdateChecker;
import me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameruleManager extends JavaPlugin {

    private static GameruleManager plugin;
    public static String Serverversion;
    public static String sversion;



    @SuppressWarnings({"ConstantConditions", "unused"})
    @Override
    public void onEnable() {

        sversion = Bukkit.getBukkitVersion();
        //1.18.2-R01-SNAPSHOT //1.8.2
        if (sversion.charAt(3) != '.') {
            Serverversion = new String(new char[]{sversion.charAt(2), sversion.charAt(3)});
        } else {
            getLogger().info("This plugin doesn't support your server version " + ChatColor.RED + sversion + ChatColor.YELLOW + "...Disabling it");
            this.getPluginLoader().disablePlugin(this);
        }
        plugin = this;
        getCommand("gamerule").setExecutor(new GuiCommand());
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getServer().getPluginManager().registerEvents(new WorldSelectorListener(), this);
        new UpdateChecker(this, 102215).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                getLogger().info("There is not a new update available.");
            } else if (Double.parseDouble(this.getDescription().getVersion()) < Double.parseDouble(version)){
                getLogger().info("There is a new update available.");
            } else {
                getLogger().info("You are using a version newer than spigot uploaded version.");
            }
        });
        Metrics metrics = new Metrics(this,15346);

    }


    public static GameruleManager getPlugin() {
        return plugin;
    }
}
