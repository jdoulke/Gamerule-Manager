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

public class PlayersSleepingPercentage {

    public PlayersSleepingPercentage(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack playersSleepingPercentage(World w) {


        World playerworld = w;


        ArrayList<String> lore = new ArrayList<>();

        ItemStack playersSleepingPercentage = new ItemStack(Material.WHITE_BED, 1);
        ItemMeta playersSleepingPercentagemeta = playersSleepingPercentage.getItemMeta();
        playersSleepingPercentagemeta.setDisplayName(ChatColor.RED + "playersSleepingPercentage");
        playersSleepingPercentagemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + playerworld.getGameRuleValue(GameRule.PLAYERS_SLEEPING_PERCENTAGE));
        lore.add("");
        lore.add("What percentage of players");
        lore.add("must sleep to skip the night.");
        lore.add("");
        lore.add("Default value is: 100");
        playersSleepingPercentagemeta.setLore(lore);
        playersSleepingPercentage.setItemMeta(playersSleepingPercentagemeta);

        return playersSleepingPercentage;
    }

}
