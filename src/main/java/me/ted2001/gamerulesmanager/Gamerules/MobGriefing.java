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

public class MobGriefing {

    public MobGriefing(){

    }
    private WorldSelectorListener world;
    public ItemStack mobGriefing(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack mobGriefing = new ItemStack(Material.OAK_DOOR);

        ItemMeta mobGriefingmeta = mobGriefing.getItemMeta();

        mobGriefingmeta.setDisplayName(ChatColor.RED + "mobGriefing");
        if(playerworld.getGameRuleValue(GameRule.MOB_GRIEFING)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether mobs can pick up ");
        lore.add("items and be able to ");
        lore.add("change blocks.");
        lore.add("");
        lore.add("Default value is: true");
        mobGriefingmeta.setLore(lore);
        mobGriefing.setItemMeta(mobGriefingmeta);


        return mobGriefing;
    }
}
