package me.ted2001.gamerulesmanager.Gamerules;

import me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DoDaylightCycle {

    public DoDaylightCycle(){

    }
    private WorldSelectorListener world;
    public ItemStack doDaylightCycle(CommandSender sender){
        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doDaylightCycle = new ItemStack(Material.CLOCK);
        ItemMeta doDaylightCyclemeta = doDaylightCycle.getItemMeta();
        doDaylightCyclemeta.setDisplayName(ChatColor.RED + "doDaylightCyclemeta");
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
