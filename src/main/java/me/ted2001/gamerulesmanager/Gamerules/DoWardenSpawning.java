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

public class DoWardenSpawning {

    public DoWardenSpawning(){

    }
    private WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doWardenSpawning(CommandSender sender) {
        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doWardenSpawning = new ItemStack(Material.WARDEN_SPAWN_EGG);

        ItemMeta doWardenSpawningmeta = doWardenSpawning.getItemMeta();

        doWardenSpawningmeta.setDisplayName(ChatColor.RED + "doWardenSpawning");
        if (playerworld.getGameRuleValue(GameRule.DO_WARDEN_SPAWNING)) {
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        } else {
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether wardens can spawn");
        lore.add("");
        lore.add("Default value is: true");
        doWardenSpawningmeta.setLore(lore);
        doWardenSpawning.setItemMeta(doWardenSpawningmeta);


        return doWardenSpawning;
    }
}
