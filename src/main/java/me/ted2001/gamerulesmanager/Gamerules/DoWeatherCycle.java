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

public class DoWeatherCycle {
    public DoWeatherCycle(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doWeatherCycle(World w) {

        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doWeatherCycle = new ItemStack(Material.SNOWBALL);

        ItemMeta doWeatherCyclemeta = doWeatherCycle.getItemMeta();

        doWeatherCyclemeta.setDisplayName(ChatColor.RED + "doWeatherCycle");
        doWeatherCyclemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_WEATHER_CYCLE)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the weather can");
        lore.add("change naturally.");
        lore.add("");
        lore.add("Default value is: true");
        doWeatherCyclemeta.setLore(lore);
        doWeatherCycle.setItemMeta(doWeatherCyclemeta);


        return doWeatherCycle;
    }
}
