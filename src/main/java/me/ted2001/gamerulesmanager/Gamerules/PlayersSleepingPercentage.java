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

public class PlayersSleepingPercentage {

    public PlayersSleepingPercentage(){}
    private WorldSelectorListener world;
    public ItemStack playersSleepingPercentage(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();


        ArrayList<String> lore = new ArrayList<>();

        ItemStack playersSleepingPercentage = new ItemStack(Material.WHITE_BED, 1);
        ItemMeta playersSleepingPercentagemeta = playersSleepingPercentage.getItemMeta();
        playersSleepingPercentagemeta.setDisplayName(ChatColor.RED + "playersSleepingPercentage");
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
