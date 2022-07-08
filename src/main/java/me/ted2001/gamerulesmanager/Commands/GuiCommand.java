package me.ted2001.gamerulesmanager.Commands;


import me.ted2001.gamerulesmanager.Gamerules.*;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class GuiCommand implements CommandExecutor {


    public GuiCommand(){}
    @SuppressWarnings("NullableProblems")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player ){
            //get player
            Player p = (Player) sender;
            if(p.hasPermission("gamerulemanager.use"))
                p.openInventory(guiBuilder(p));
            else
                p.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
        }

        return false;
    }


    public Inventory guiBuilder(Player p){
            String version = Bukkit.getBukkitVersion();
            //1.18.2-R01-SNAPSHOT //1.8.2
            String Serverversion;
            if(version.charAt(3) != '.'){
                Serverversion = new String(new char[] {version.charAt(2),version.charAt(3)});
            }else{
                p.sendMessage(ChatColor.YELLOW + "This plugin doesn't support your server version " + ChatColor.RED + version +ChatColor.YELLOW +".");
                return null;
            }

            GameruleGetter Getter = new GameruleGetter(p);
            //sizes 9,18,27,36,45,54
            Inventory gui = Bukkit.createInventory(p,36, ChatColor.GREEN + "" + ChatColor.BOLD + "Gamerule Gui Manager");

            //add items from the Gamerules classes.
            gui.setItem(0, Getter.announceAdvancements());
            gui.setItem(1, Getter.commandBlockOutput());
            gui.setItem(2, Getter.disableElytraMovementCheck());
            gui.setItem(3, Getter.daylightCycle());
            gui.setItem(4, Getter.entityDrops());
            gui.setItem(5, Getter.doFireTick());
            gui.setItem(6, Getter.mobGriefing());
            gui.setItem(7, Getter.doMobSpawning());
            gui.setItem(8, Getter.doMobLoot());
            gui.setItem(9, Getter.doTileDrops());
            gui.setItem(10, Getter.keepInventory());
            gui.setItem(11, Getter.naturalRegeneration());
            gui.setItem(12, Getter.logAdminCommands());
            gui.setItem(13, Getter.showDeathMessages());
            gui.setItem(14, Getter.sendCommandFeedback());
            gui.setItem(15, Getter.randomTickSpeed());
            gui.setItem(16, Getter.reducedDebugInfo());
            gui.setItem(17, Getter.spectatorsGenerateChunks());
            gui.setItem(18, Getter.spawnRadius());
            gui.setItem(19, Getter.doWeatherCycle());
            gui.setItem(20, Getter.maxEntityCramming());
            gui.setItem(21, Getter.doLimitedCrafting());
            gui.setItem(22, Getter.maxCommandChainLength());


            //gamerules from 1.14
            if(Integer.parseInt(Serverversion) >=14)
                gui.setItem(23, Getter.disableRaids());


            //gamerules from 1.15
            if(Integer.parseInt(Serverversion) >= 15){
                gui.setItem(24, Getter.doInsomnia());
                gui.setItem(25, Getter.doImmediateRespawn());
                gui.setItem(26, Getter.drowningDamage());
                gui.setItem(27, Getter.fireDamage());
                gui.setItem(28, Getter.fallDamage());
            }

            //gamerules from 1.15.2
            if((Integer.parseInt(Serverversion) == 15 && version.charAt(5) == 2) || Integer.parseInt(Serverversion) >= 16) {
                gui.setItem(29, Getter.doPatrolSpawning());
                gui.setItem(30, Getter.doTraderSpawning());
            }

            //gamerules from 1.16
            if(Integer.parseInt(Serverversion) >=16) {
                gui.setItem(31, Getter.universalAnger());
                gui.setItem(32, Getter.forgiveDeadPlayers());
            }

            //gamerules from 1.17
            if(Integer.parseInt(Serverversion) >=17) {
                gui.setItem(33, Getter.freezeDamage());
                gui.setItem(34, Getter.playersSleepingPercentage());
            }
            //gamerule from 1.19
            if(Integer.parseInt(Serverversion) >=19) {
            gui.setItem(35, Getter.doWardenSpawning());
            }

            return gui;

    }



}
