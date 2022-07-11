package me.ted2001.gamerulesmanager.Listeners;

import me.ted2001.gamerulesmanager.GUI.GUI;
import me.ted2001.gamerulesmanager.Gamerules.GameruleGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class WorldSelectorListener implements Listener {

    public World getWorldSelected() {
        return WorldSelected;
    }

    public World WorldSelected;
    private GUI GUI = new GUI();
    private ItemStack Normal = new ItemStack(Material.GRASS_BLOCK);
    private ItemStack Nether = new ItemStack(Material.NETHERRACK);
    private ItemStack End = new ItemStack(Material.END_STONE);

    public void setWorldSelected(World worldSelected) {
        WorldSelected = worldSelected;
    }

    @EventHandler
    public void onGuiClick(InventoryClickEvent e) {
        try {
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "Worlds Selector")) {
                if (e.getCurrentItem() == null)
                    return;
                e.setCancelled(true);
                Player p = (Player) e.getWhoClicked();
                String world_name;
                String clickitem = e.getCurrentItem().getType().toString();
                if(clickitem.equalsIgnoreCase("GRASS_BLOCK") || clickitem.equalsIgnoreCase("NETHERRACK") || clickitem.equalsIgnoreCase("END_STONE")) {
                    world_name = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
                    World world = Bukkit.getServer().getWorld(world_name);
                    p.openInventory(gameruleSetterGui(p,world));
                }

            }
        } catch (NullPointerException ex) {}
    }
    public Inventory gameruleSetterGui(Player p,World w) {
        String version = Bukkit.getBukkitVersion();
        //1.18.2-R01-SNAPSHOT //1.8.2
        String Serverversion;
        if (version.charAt(3) != '.') {
            Serverversion = new String(new char[]{version.charAt(2), version.charAt(3)});
        } else {
            p.sendMessage(ChatColor.YELLOW + "This plugin doesn't support your server version " + ChatColor.RED + version + ChatColor.YELLOW + ".");
            return null;
        }
        GameruleGetter Getter = new GameruleGetter(w);
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


}
