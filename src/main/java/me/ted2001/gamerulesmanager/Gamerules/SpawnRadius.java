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

public class SpawnRadius {

    public SpawnRadius(){}
    private WorldSelectorListener world;
    public ItemStack spawnRadius(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();


        ArrayList<String> lore = new ArrayList<>();

        ItemStack spawnRadius = new ItemStack(Material.RED_BED, 1);
        ItemMeta spawnRadiussmeta = spawnRadius.getItemMeta();
        spawnRadiussmeta.setDisplayName(ChatColor.RED + "spawnRadius");
        lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + playerworld.getGameRuleValue(GameRule.SPAWN_RADIUS));
        lore.add("");
        lore.add("The number of blocks outward");
        lore.add("from the world spawn coordinates");
        lore.add("that a player spawns in when first");
        lore.add("joining a server or when dying ");
        lore.add("without a personal spawnpoint.");
        lore.add("");
        lore.add("Default value is: 10");
        spawnRadiussmeta.setLore(lore);
        spawnRadius.setItemMeta(spawnRadiussmeta);

        return spawnRadius;
    }
}
