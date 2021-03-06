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

public class SendCommandFeedback {

    public SendCommandFeedback(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack sendCommandFeedback(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack sendCommandFeedback = new ItemStack(Material.REDSTONE_LAMP);

        ItemMeta sendCommandFeedbackmeta = sendCommandFeedback.getItemMeta();

        sendCommandFeedbackmeta.setDisplayName(ChatColor.RED + "sendCommandFeedback");
        sendCommandFeedbackmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the feedback from commands");
        lore.add("commands executed by a player");
        lore.add("should show up in chat.");
        lore.add("");
        lore.add("Default value is: true");
        sendCommandFeedbackmeta.setLore(lore);
        sendCommandFeedback.setItemMeta(sendCommandFeedbackmeta);


        return sendCommandFeedback;
    }

}
