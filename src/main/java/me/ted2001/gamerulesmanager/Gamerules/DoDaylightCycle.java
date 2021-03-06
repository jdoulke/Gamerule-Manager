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

public class DoDaylightCycle {

    public DoDaylightCycle(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doDaylightCycle(World w){

        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doDaylightCycle = new ItemStack(Material.CLOCK);
        ItemMeta doDaylightCyclemeta = doDaylightCycle.getItemMeta();
        doDaylightCyclemeta.setDisplayName(ChatColor.RED + "doDaylightCyclemeta");
        doDaylightCyclemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the daylight cycle");
        lore.add("moon phases progress.");
        lore.add("");
        lore.add("Default value is: true");
        doDaylightCyclemeta.setLore(lore);
        doDaylightCycle.setItemMeta(doDaylightCyclemeta);



        return doDaylightCycle;

    }
}
