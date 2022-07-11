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

public class CommandBlockOutput {

    public CommandBlockOutput(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack commandBlockOutput(World w){


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();


        ItemStack commandBlockOutput = new ItemStack(Material.COMMAND_BLOCK,1);
        ItemMeta commandBlockOutputmeta = commandBlockOutput.getItemMeta();
        commandBlockOutputmeta.setDisplayName(ChatColor.RED + "commandBlockOutput");
        if(playerworld.getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether command blocks");
        lore.add("should be enabled in-game.");
        lore.add("");
        lore.add("Default value is: true");
        commandBlockOutputmeta.setLore(lore);
        commandBlockOutput.setItemMeta(commandBlockOutputmeta);

        return commandBlockOutput;
    }
}
