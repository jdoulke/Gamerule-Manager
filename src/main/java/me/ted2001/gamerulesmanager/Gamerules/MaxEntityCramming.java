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

public class MaxEntityCramming {

    public MaxEntityCramming(){}

    public ItemStack maxEntityCramming(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = p.getWorld();


        ArrayList<String> lore = new ArrayList<>();

        ItemStack maxEntityCramming = new ItemStack(Material.ZOMBIE_HEAD, 1);
        ItemMeta maxEntityCrammingmeta = maxEntityCramming.getItemMeta();
        maxEntityCrammingmeta.setDisplayName(ChatColor.RED + "maxEntityCramming");
        lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + playerworld.getGameRuleValue(GameRule.MAX_ENTITY_CRAMMING));
        lore.add("");
        lore.add("The maximum number of pushable");
        lore.add("entities a mob or player can push");
        lore.add("before taking 3 suffocation damage");
        lore.add("per half-second.");
        lore.add("without a personal spawnpoint.");
        lore.add("");
        lore.add("Default value is: 24");
        maxEntityCrammingmeta.setLore(lore);
        maxEntityCramming.setItemMeta(maxEntityCrammingmeta);

        return maxEntityCramming;
    }

}
