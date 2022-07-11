package me.ted2001.gamerulesmanager.Gamerules;

import me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KeepInventory {

    public KeepInventory(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack keepInventory(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack keepInventory = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta keepInventorymeta = keepInventory.getItemMeta();
        keepInventorymeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);

        keepInventorymeta.setDisplayName(ChatColor.RED + "keepInventory");
        if(playerworld.getGameRuleValue(GameRule.KEEP_INVENTORY)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the player should");
        lore.add("keep items and experience");
        lore.add("in their inventory after death.");
        lore.add("");
        lore.add("Default value is: false");
        keepInventorymeta.setLore(lore);
        keepInventory.setItemMeta(keepInventorymeta);


        return keepInventory;
    }
}
