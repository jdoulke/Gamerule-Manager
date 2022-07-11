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

public class DoInsomnia {

    public DoInsomnia(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doInsomnia(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doInsomnia = new ItemStack(Material.PHANTOM_SPAWN_EGG);

        ItemMeta doInsomniameta = doInsomnia.getItemMeta();

        doInsomniameta.setDisplayName(ChatColor.RED + "doInsomnia");
        if(playerworld.getGameRuleValue(GameRule.DO_INSOMNIA)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether phantoms can");
        lore.add("spawn in the nighttime .");
        lore.add("");
        lore.add("Default value is: true");
        doInsomniameta.setLore(lore);
        doInsomnia.setItemMeta(doInsomniameta);


        return doInsomnia;
    }
}
