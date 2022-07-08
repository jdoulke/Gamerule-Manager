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

public class AnnounceAdvancements {

    public AnnounceAdvancements(){

    }

    public ItemStack announceAdvancementz(CommandSender sender){
        Player p = (Player) sender;
        //get player's world
        World playerworld = p.getWorld();



        ArrayList<String> lore = new ArrayList<>();
        ItemStack announceAdvancements = new ItemStack(Material.BOOK,1);
        ItemMeta announceAdvancementsmeta = announceAdvancements.getItemMeta();
        announceAdvancementsmeta.setDisplayName(ChatColor.RED + "announceAdvancements");
        if(playerworld.getGameRuleValue(GameRule.ANNOUNCE_ADVANCEMENTS)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }

        lore.add("");
        lore.add("Whether command blocks");
        lore.add("should notify admins when");
        lore.add("they perform commands");
        lore.add("");
        lore.add("Default value is: true");
        announceAdvancementsmeta.setLore(lore);
        announceAdvancements.setItemMeta(announceAdvancementsmeta);


        return announceAdvancements;
    }

}
