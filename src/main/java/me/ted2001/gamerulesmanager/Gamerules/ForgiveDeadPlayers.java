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

public class ForgiveDeadPlayers {

    public ForgiveDeadPlayers(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack forgiveDeadPlayers(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack forgiveDeadPlayers = new ItemStack(Material.FEATHER);

        ItemMeta forgiveDeadPlayersmeta = forgiveDeadPlayers.getItemMeta();


        forgiveDeadPlayersmeta.setDisplayName(ChatColor.RED + "forgiveDeadPlayers");
        forgiveDeadPlayersmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.FORGIVE_DEAD_PLAYERS)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Makes angered neutral mobs");
        lore.add("stop being angry when the");
        lore.add("targeted player dies nearby.");
        lore.add("");
        lore.add("Default value is: true");
        forgiveDeadPlayersmeta.setLore(lore);
        forgiveDeadPlayers.setItemMeta(forgiveDeadPlayersmeta);


        return forgiveDeadPlayers;
    }

}
