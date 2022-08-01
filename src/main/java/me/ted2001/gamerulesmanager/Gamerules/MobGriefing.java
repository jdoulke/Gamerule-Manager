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

public class MobGriefing {

    public MobGriefing(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack mobGriefing(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack mobGriefing = new ItemStack(Material.OAK_DOOR);

        ItemMeta mobGriefingmeta = mobGriefing.getItemMeta();

        mobGriefingmeta.setDisplayName(ChatColor.RED + "mobGriefing");
        mobGriefingmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
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
