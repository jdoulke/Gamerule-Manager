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

public class DoImmediateRespawn {

    public DoImmediateRespawn(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doImmediateRespawn(World w){


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();
        ItemStack doImmediateRespawn = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemMeta doImmediateRespawnmeta = doImmediateRespawn.getItemMeta();
        doImmediateRespawnmeta.setDisplayName(ChatColor.RED + "doImmediateRespawn");
        doImmediateRespawnmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Players respawn immediately ");
        lore.add("without showing the death screen.");
        lore.add("");
        lore.add("Default value is: false");
        doImmediateRespawnmeta.setLore(lore);
        doImmediateRespawn.setItemMeta(doImmediateRespawnmeta);

        return doImmediateRespawn;
    }
}
