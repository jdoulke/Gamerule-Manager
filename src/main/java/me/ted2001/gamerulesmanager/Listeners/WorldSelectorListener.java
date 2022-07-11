package me.ted2001.gamerulesmanager.Listeners;

import me.ted2001.gamerulesmanager.GUI.GUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
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
                    world_name = e.getCurrentItem().getItemMeta().getDisplayName();
                    World world = Bukkit.getWorld(world_name);
                    WorldSelected = world;
                    p.openInventory(GUI.gameruleSetterGui(p,world));
                }

            }
        } catch (NullPointerException ex) {}
    }


}
