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

public class DoFireTick {

    public DoFireTick(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doFireTick(World w){


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();
        ItemStack doFireTick = new ItemStack(Material.FLINT_AND_STEEL,1);
        ItemMeta doFireTickmeta = doFireTick.getItemMeta();
        doFireTickmeta.setDisplayName(ChatColor.RED + "doFireTick");
        doFireTickmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_FIRE_TICK)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether fire should spread");
        lore.add("and naturally extinguish.");
        lore.add("");
        lore.add("Default value is: true");
        doFireTickmeta.setLore(lore);
        doFireTick.setItemMeta(doFireTickmeta);

        return doFireTick;
    }
}
