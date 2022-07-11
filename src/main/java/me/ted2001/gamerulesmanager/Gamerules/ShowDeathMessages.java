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

public class ShowDeathMessages {

     public ShowDeathMessages(){

     }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack showDeathMessages(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack showDeathMessages = new ItemStack(Material.PAPER);

        ItemMeta showDeathMessagesmeta = showDeathMessages.getItemMeta();

        showDeathMessagesmeta.setDisplayName(ChatColor.RED + "showDeathMessages");
        if(playerworld.getGameRuleValue(GameRule.SHOW_DEATH_MESSAGES)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether death messages are");
        lore.add("put into chat when a player dies.");
        lore.add("");
        lore.add("Default value is: true");
        showDeathMessagesmeta.setLore(lore);
        showDeathMessages.setItemMeta(showDeathMessagesmeta);


        return showDeathMessages;
    }


}
