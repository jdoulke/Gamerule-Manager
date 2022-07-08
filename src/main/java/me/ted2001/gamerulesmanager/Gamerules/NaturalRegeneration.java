package me.ted2001.gamerulesmanager.Gamerules;

import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class NaturalRegeneration {

    public NaturalRegeneration(){

    }

    public ItemStack naturalRegeneration(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = p.getWorld();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack naturalRegeneration = new ItemStack(Material.GOLDEN_APPLE);

        ItemMeta naturalRegenerationmeta = naturalRegeneration.getItemMeta();

        naturalRegenerationmeta.setDisplayName(ChatColor.RED + "naturalRegeneration");
        if(playerworld.getGameRuleValue(GameRule.NATURAL_REGENERATION)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the player can");
        lore.add("regenerate health naturally");
        lore.add("if their hunger is full enough.");
        lore.add("");
        lore.add("Default value is: true");
        naturalRegenerationmeta.setLore(lore);
        naturalRegeneration.setItemMeta(naturalRegenerationmeta);


        return naturalRegeneration;
    }

}
