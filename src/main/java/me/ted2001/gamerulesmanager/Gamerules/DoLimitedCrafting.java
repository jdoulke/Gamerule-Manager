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

public class DoLimitedCrafting {

    public DoLimitedCrafting(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doLimitedCrafting(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doLimitedCrafting = new ItemStack(Material.CRAFTING_TABLE);

        ItemMeta doLimitedCraftingmeta = doLimitedCrafting.getItemMeta();

        doLimitedCraftingmeta.setDisplayName(ChatColor.RED + "doLimitedCrafting");
        doLimitedCraftingmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_LIMITED_CRAFTING)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether players should be able");
        lore.add("to craft only those recipes that");
        lore.add("they've unlocked first.");
        lore.add("");
        lore.add("Default value is: false");
        doLimitedCraftingmeta.setLore(lore);
        doLimitedCrafting.setItemMeta(doLimitedCraftingmeta);


        return doLimitedCrafting;
    }

}
