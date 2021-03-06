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

public class DoEntityDrops {

    public DoEntityDrops(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doEntityDrops(World w){

        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doEntityDrops = new ItemStack(Material.ROTTEN_FLESH,1);
        ItemMeta doEntityDropsmeta = doEntityDrops.getItemMeta();
        doEntityDropsmeta.setDisplayName(ChatColor.RED + "doEntityDrops");
        doEntityDropsmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_ENTITY_DROPS)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }

        lore.add("");
        lore.add("Whether entities that are");
        lore.add("not mobs should have drops.");
        lore.add("");
        lore.add("Default value is: true");
        doEntityDropsmeta.setLore(lore);
        doEntityDrops.setItemMeta(doEntityDropsmeta);

        return doEntityDrops;
    }
}
