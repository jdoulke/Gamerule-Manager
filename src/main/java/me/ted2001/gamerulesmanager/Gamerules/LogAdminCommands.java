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

public class LogAdminCommands {

    public LogAdminCommands(){

    }
    private WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack logAdminCommands(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack logAdminCommands = new ItemStack(Material.WRITABLE_BOOK);

        ItemMeta logAdminCommandsmeta = logAdminCommands.getItemMeta();

        logAdminCommandsmeta.setDisplayName(ChatColor.RED + "logAdminCommands");
        if(playerworld.getGameRuleValue(GameRule.LOG_ADMIN_COMMANDS)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether to log admin");
        lore.add("commands to server log.");
        lore.add("");
        lore.add("Default value is: true");
        logAdminCommandsmeta.setLore(lore);
        logAdminCommands.setItemMeta(logAdminCommandsmeta);


        return logAdminCommands;
    }

}
