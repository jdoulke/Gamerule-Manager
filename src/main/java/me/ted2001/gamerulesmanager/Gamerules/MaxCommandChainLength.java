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

public class MaxCommandChainLength {

    public MaxCommandChainLength(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack maxCommandChainLength(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();


        ArrayList<String> lore = new ArrayList<>();

        ItemStack maxCommandChainLength = new ItemStack(Material.CHAIN_COMMAND_BLOCK, 1);
        ItemMeta maxCommandChainLengthmeta = maxCommandChainLength.getItemMeta();
        maxCommandChainLengthmeta.setDisplayName(ChatColor.RED + "maxCommandChainLength");
        lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + playerworld.getGameRuleValue(GameRule.MAX_COMMAND_CHAIN_LENGTH));
        lore.add("");
        lore.add("The maximum length of a chain");
        lore.add("of commands that can be executed");
        lore.add("during one tick. Applies to");
        lore.add("command blocks and functions.");
        lore.add("");
        lore.add("Default value is: 65536");
        maxCommandChainLengthmeta.setLore(lore);
        maxCommandChainLength.setItemMeta(maxCommandChainLengthmeta);

        return maxCommandChainLength;
    }
}
