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

public class UniversalAnger {


    public UniversalAnger(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack universalAnger(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack universalAnger = new ItemStack(Material.SPIDER_EYE);

        ItemMeta universalAngermeta = universalAnger.getItemMeta();


        universalAngermeta.setDisplayName(ChatColor.RED + "universalAnger");
        universalAngermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.UNIVERSAL_ANGER)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Makes angered neutral mobs");
        lore.add("attack any nearby player, not");
        lore.add("just the player that angered them.");
        lore.add("Works best if forgiveDeadPlayers");
        lore.add("is disabled.");
        lore.add("");
        lore.add("Default value is: false");
        universalAngermeta.setLore(lore);
        universalAnger.setItemMeta(universalAngermeta);


        return universalAnger;
    }

}
