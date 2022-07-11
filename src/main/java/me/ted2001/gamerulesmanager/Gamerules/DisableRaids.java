package me.ted2001.gamerulesmanager.Gamerules;

import me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DisableRaids {

    public DisableRaids(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack disableRaids(CommandSender sender){
            Player p = (Player) sender;

            World playerworld = world.getWorldSelected();

            ArrayList<String> lore = new ArrayList<>();

            ItemStack disableRaids = new ItemStack(Material.CROSSBOW);
            ItemMeta disableRaidsmeta = disableRaids.getItemMeta();
            disableRaidsmeta.setDisplayName(ChatColor.RED + "disableRaids");

            if (playerworld.getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

            } else {
                lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
            }
            lore.add("");
            lore.add("Whether raids are disabled.");
            lore.add("");
            lore.add("Default value is: false");
            disableRaidsmeta.setLore(lore);
            disableRaids.setItemMeta(disableRaidsmeta);

            return disableRaids;
    }
}
