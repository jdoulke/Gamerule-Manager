package me.ted2001.gamerulesmanager.Gamerules;

import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ReducedDebugInfo {

    public ReducedDebugInfo() {

    }

    public ItemStack reducedDebugInfo(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = p.getWorld();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack reducedDebugInfo = new ItemStack(Material.REDSTONE_TORCH);

        ItemMeta reducedDebugInfometa = reducedDebugInfo.getItemMeta();

        reducedDebugInfometa.setDisplayName(ChatColor.RED + "reducedDebugInfo");
        if (playerworld.getGameRuleValue(GameRule.REDUCED_DEBUG_INFO)) {
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        } else {
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the debug screen");
        lore.add("shows all or reduced information");
        lore.add("and whether the effects of");
        lore.add("(F3 + B) and (F3 + G) are shown.");
        lore.add("");
        lore.add("Default value is: false");
        reducedDebugInfometa.setLore(lore);
        reducedDebugInfo.setItemMeta(reducedDebugInfometa);

        return reducedDebugInfo;


    }
}
