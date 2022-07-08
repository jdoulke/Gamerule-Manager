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

public class DoMobSpawning {

    public DoMobSpawning(){

    }

    public ItemStack doMobSpawning(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = p.getWorld();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doMobSpawning = new ItemStack(Material.CHICKEN_SPAWN_EGG);

        ItemMeta doMobSpawningmeta = doMobSpawning.getItemMeta();

        doMobSpawningmeta.setDisplayName(ChatColor.RED + "doMobSpawning");
        if(playerworld.getGameRuleValue(GameRule.DO_MOB_SPAWNING)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether mobs should");
        lore.add("naturally spawn.");
        lore.add("change blocks.Does not");
        lore.add("affect monster spawners.");
        lore.add("");
        lore.add("Default value is: true");
        doMobSpawningmeta.setLore(lore);
        doMobSpawning.setItemMeta(doMobSpawningmeta);


        return doMobSpawning;
    }
}
