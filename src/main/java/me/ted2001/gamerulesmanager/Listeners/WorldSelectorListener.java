package me.ted2001.gamerulesmanager.Listeners;

import me.ted2001.gamerulesmanager.GUI.GUI;
import me.ted2001.gamerulesmanager.Gamerules.GameruleGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class WorldSelectorListener implements Listener {

    public World getWorldSelected() {
        return WorldSelected;
    }

    public World WorldSelected;
    private GUI GUI;

    @EventHandler
    public void onGuiClick(InventoryClickEvent e) {
        try {
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "Worlds Selector")) {
                if (e.getCurrentItem() == null)
                    return;
                Inventory gui = e.getClickedInventory();
                Player p = (Player) e.getWhoClicked();
                String world_name = e.getCursor().toString();
                World world = Bukkit.getWorld(world_name);
                WorldSelected = world;
                p.closeInventory();
                p.openInventory(GUI.gameruleSetterGui(p,world));
                e.setCancelled(true);
            }
        } catch (NullPointerException ex) {}
    }


}
