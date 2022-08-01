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

public class DoMobLoot {

    public DoMobLoot(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doMobLoot(World w) {

        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doMobLoot = new ItemStack(Material.EXPERIENCE_BOTTLE);

        ItemMeta doMobLootmeta = doMobLoot.getItemMeta();

        doMobLootmeta.setDisplayName(ChatColor.RED + "doMobLoot");
        doMobLootmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_MOB_LOOT)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether mobs should drop");
        lore.add("items and experience orbs.");
        lore.add("");
        lore.add("Default value is: true");
        doMobLootmeta.setLore(lore);
        doMobLoot.setItemMeta(doMobLootmeta);


        return doMobLoot;
    }
}
