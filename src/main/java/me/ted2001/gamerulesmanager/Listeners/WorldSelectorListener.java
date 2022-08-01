package me.ted2001.gamerulesmanager.Listeners;

import me.ted2001.gamerulesmanager.GUI.GUI;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static me.ted2001.gamerulesmanager.GameruleManager.Serverversion;


public class WorldSelectorListener implements Listener {


    public static World WorldSelected;
    private GUI GUI = new GUI();


    public void setWorldSelected(World worldSelected) {
        WorldSelected = worldSelected;
    }

    @EventHandler
    public void onGuiClick(InventoryClickEvent e) {
        try {
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "World Selector")) {
                if (e.getCurrentItem() == null)
                    return;
                e.setCancelled(true);
                Player p = (Player) e.getWhoClicked();
                String world_name;
                String clickitem = e.getCurrentItem().getType().toString();
                if(clickitem.equalsIgnoreCase("GRASS_BLOCK") || clickitem.equalsIgnoreCase("NETHERRACK") || clickitem.equalsIgnoreCase("END_STONE")) {
                    world_name = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
                    World world = Bukkit.getServer().getWorld(world_name);
                    setWorldSelected(world);
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
                    p.openInventory(GUI.gameruleSetterGui(p,world));
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "EXIT")) {
                    p.closeInventory();
                    if(Integer.parseInt(Serverversion) >= 14)
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE, 1,1);
                    else
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_YES, 1,1);
                }

            }
        } catch (NullPointerException ex) {}
    }



}
