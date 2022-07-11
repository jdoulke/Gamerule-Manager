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

public class AnnounceAdvancements {

    public AnnounceAdvancements(){}

    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack announceAdvancementz(World w){
        //get player's world
        World playerworld = w;



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
