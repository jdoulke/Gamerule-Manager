package me.ted2001.gamerulesmanager.GUI;

import me.ted2001.gamerulesmanager.Gamerules.GameruleGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GUI {


    public Inventory gameruleSetterGui(Player p) {
        String version = Bukkit.getBukkitVersion();
        //1.18.2-R01-SNAPSHOT //1.8.2
        String Serverversion;
        if (version.charAt(3) != '.') {
            Serverversion = new String(new char[]{version.charAt(2), version.charAt(3)});
        } else {
            p.sendMessage(ChatColor.YELLOW + "This plugin doesn't support your server version " + ChatColor.RED + version + ChatColor.YELLOW + ".");
            return null;
        }
        GameruleGetter Getter = new GameruleGetter(p);
        //sizes 9,18,27,36,45,54
        Inventory gui = Bukkit.createInventory(p, 36, ChatColor.GREEN + "" + ChatColor.BOLD + "Gamerule GUI Manager");

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
        if (Integer.parseInt(Serverversion) >= 14)
            gui.setItem(23, Getter.disableRaids());


        //gamerules from 1.15
        if (Integer.parseInt(Serverversion) >= 15) {
            gui.setItem(24, Getter.doInsomnia());
            gui.setItem(25, Getter.doImmediateRespawn());
            gui.setItem(26, Getter.drowningDamage());
            gui.setItem(27, Getter.fireDamage());
            gui.setItem(28, Getter.fallDamage());
        }

        //gamerules from 1.15.2
        if ((Integer.parseInt(Serverversion) == 15 && version.charAt(5) == 2) || Integer.parseInt(Serverversion) >= 16) {
            gui.setItem(29, Getter.doPatrolSpawning());
            gui.setItem(30, Getter.doTraderSpawning());
        }

        //gamerules from 1.16
        if (Integer.parseInt(Serverversion) >= 16) {
            gui.setItem(31, Getter.universalAnger());
            gui.setItem(32, Getter.forgiveDeadPlayers());
        }

        //gamerules from 1.17
        if (Integer.parseInt(Serverversion) >= 17) {
            gui.setItem(33, Getter.freezeDamage());
            gui.setItem(34, Getter.playersSleepingPercentage());
        }
        //gamerule from 1.19
        if (Integer.parseInt(Serverversion) >= 19) {
            gui.setItem(35, Getter.doWardenSpawning());
        }

        return gui;
    }

    public Inventory guiBuilder(Player p) {
        Inventory world_selector = Bukkit.createInventory(p, 36, ChatColor.AQUA + "" + ChatColor.BOLD + "Worlds Selector");
        List<World> worlds = Bukkit.getWorlds();
        String worldtype;
        for (World world : worlds) {
            worldtype = world.getEnvironment().toString();
            if (worldtype.equalsIgnoreCase("NORMAL") || worldtype.equalsIgnoreCase("CUSTOM"))
                world_selector.addItem(worldCreator("NORMAL", world.getName()));
            else if (worldtype.equalsIgnoreCase("NETHER"))
                world_selector.addItem(worldCreator("NETHER", world.getName()));
            else if (worldtype.equalsIgnoreCase("THE_END"))
                world_selector.addItem(worldCreator("END", world.getName()));
        }


        return world_selector;
    }
    private ItemStack worldCreator(String type, String name){
        ItemStack world;
        ItemMeta worldmeta;
        if(type.equalsIgnoreCase("NORMAL")){
            world = new ItemStack(Material.GRASS_BLOCK);
            worldmeta = world.getItemMeta();
            if (worldmeta != null)
                worldmeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + name);
            world.setItemMeta(worldmeta);
            return world;
        }
        else if(type.equalsIgnoreCase("NETHER")){
            world = new ItemStack(Material.NETHERRACK);
            worldmeta = world.getItemMeta();
            if (worldmeta != null)
                worldmeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + name);
            world.setItemMeta(worldmeta);
            return world;
        }
        else if(type.equalsIgnoreCase("END")){
            world = new ItemStack(Material.END_STONE);
            worldmeta = world.getItemMeta();
            if (worldmeta != null)
                worldmeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + name);
            world.setItemMeta(worldmeta);
            return world;
        }

        return null;
    }
}
