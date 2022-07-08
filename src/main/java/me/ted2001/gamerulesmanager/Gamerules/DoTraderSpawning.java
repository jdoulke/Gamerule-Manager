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

public class DoTraderSpawning {

    public DoTraderSpawning(){}

    public ItemStack doTraderSpawning(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = p.getWorld();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doTraderSpawning = new ItemStack(Material.WANDERING_TRADER_SPAWN_EGG);

        ItemMeta doTraderSpawningmeta = doTraderSpawning.getItemMeta();


        doTraderSpawningmeta.setDisplayName(ChatColor.RED + "doTraderSpawning");
        if(playerworld.getGameRuleValue(GameRule.DO_TRADER_SPAWNING)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether wandering traders can spawn.");
        lore.add("");
        lore.add("Default value is: true");
        doTraderSpawningmeta.setLore(lore);
        doTraderSpawning.setItemMeta(doTraderSpawningmeta);


        return doTraderSpawning;
    }

}
