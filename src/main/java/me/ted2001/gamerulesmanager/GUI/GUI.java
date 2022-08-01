package me.ted2001.gamerulesmanager.GUI;

import me.ted2001.gamerulesmanager.Gamerules.GameruleGetter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.ted2001.gamerulesmanager.GameruleManager.Serverversion;
import static me.ted2001.gamerulesmanager.GameruleManager.sversion;
import static me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener.WorldSelected;

public class GUI {


    public Inventory gameruleSetterGui(Player p,World w) {

        GameruleGetter Getter = new GameruleGetter(w);
        //sizes 9,18,27,36,45,54
        Inventory gui = Bukkit.createInventory(p, 54, ChatColor.DARK_PURPLE + "Gamerule Manager" + ChatColor.AQUA + " " +ChatColor.BOLD+WorldSelected.getName());

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
        if ((Integer.parseInt(Serverversion) == 15 && sversion.charAt(5) == 2) || Integer.parseInt(Serverversion) >= 16) {
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


        gui.setItem(45, backButton());
        gui.setItem(48, copyButton(WorldSelected));
        gui.setItem(49, pasteButton());
        gui.setItem(52, resetButton());
        gui.setItem(53, exitButton());
        return gui;
    }

    public Inventory guiBuilder(Player p) {
        Inventory world_selector = Bukkit.createInventory(p, 36, ChatColor.AQUA + "" + ChatColor.BOLD + "World Selector");
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

        world_selector.setItem(35, exitButton());


        return world_selector;
    }
    private ItemStack worldCreator(String type, String name){
        ItemStack world;
        ItemMeta worldmeta;
        if(type.equalsIgnoreCase("NORMAL")){
            world = new ItemStack(Material.GRASS_BLOCK);
            worldmeta = world.getItemMeta();
            if (worldmeta != null) {
                worldmeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + name);
                worldmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
            }
            world.setItemMeta(worldmeta);
            return world;
        }
        else if(type.equalsIgnoreCase("NETHER")){
            world = new ItemStack(Material.NETHERRACK);
            worldmeta = world.getItemMeta();
            if (worldmeta != null) {
                worldmeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + name);
                worldmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
            }
            world.setItemMeta(worldmeta);
            return world;
        }
        else if(type.equalsIgnoreCase("END")){
            world = new ItemStack(Material.END_STONE);
            worldmeta = world.getItemMeta();
            if (worldmeta != null) {
                worldmeta.setDisplayName(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + name);
                worldmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
            }
            world.setItemMeta(worldmeta);
            return world;
        }

        return null;
    }

    private ItemStack backButton(){
        ItemStack backButton = new ItemStack(Material.ARROW,1);
        ItemMeta backButtonmeta = backButton.getItemMeta();
        backButtonmeta.setDisplayName(ChatColor.RED + "Get Back in World Selection.");
        backButtonmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        backButton.setItemMeta(backButtonmeta);

        return backButton;
    }

    private ItemStack exitButton(){
        ItemStack exitButton = new ItemStack(Material.DARK_OAK_DOOR,1);
        ItemMeta exitButtonmeta = exitButton.getItemMeta();
        exitButtonmeta.setDisplayName(ChatColor.RED + "EXIT");
        exitButtonmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        exitButton.setItemMeta(exitButtonmeta);

        return exitButton;
    }

    private ItemStack resetButton(){
        ArrayList<String> lore = new ArrayList<>();
        ItemStack resetButton = new ItemStack(Material.REDSTONE_BLOCK,1);
        ItemMeta resetButtonmeta = resetButton.getItemMeta();
        resetButtonmeta.setDisplayName(ChatColor.RED + "Reset all " + ChatColor.YELLOW + "Gamerules");
        resetButtonmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        lore.add("Reset all Gamerules");
        lore.add("to default values.");
        resetButtonmeta.setLore(lore);
        resetButton.setItemMeta(resetButtonmeta);

        return resetButton;
    }
    private ItemStack copyButton(World w){
        ArrayList<String> lore = new ArrayList<>();
        ItemStack copyButton = new ItemStack(Material.BOOK,1);
        ItemMeta copyButtonmeta = copyButton.getItemMeta();
        copyButtonmeta.setDisplayName(ChatColor.DARK_BLUE + "Copy " + ChatColor.YELLOW + "Gamerules");
        copyButtonmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        lore.add("Copy all gamerules values ");
        lore.add("from this world" + w.getName());
        copyButtonmeta.setLore(lore);
        copyButton.setItemMeta(copyButtonmeta);

        return copyButton;
    }
    private ItemStack pasteButton(){
        ArrayList<String> lore = new ArrayList<>();
        ItemStack pasteButton = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemMeta pasteButtonmeta = pasteButton.getItemMeta();
        pasteButtonmeta.setDisplayName(ChatColor.DARK_RED + "Paste " + ChatColor.YELLOW + "Gamerules");
        pasteButtonmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        lore.add("Paste all gamerules values ");
        lore.add("from the world you copied.");
        pasteButtonmeta.setLore(lore);
        pasteButton.setItemMeta(pasteButtonmeta);

        return pasteButton;
    }
}
