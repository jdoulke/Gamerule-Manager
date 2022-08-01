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

public class DoPatrolSpawning {

    public DoPatrolSpawning(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doPatrolSpawning(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doPatrolSpawning = new ItemStack(Material.PILLAGER_SPAWN_EGG);

        ItemMeta doPatrolSpawningmeta = doPatrolSpawning.getItemMeta();


        doPatrolSpawningmeta.setDisplayName(ChatColor.RED + "doPatrolSpawning");
        doPatrolSpawningmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DO_PATROL_SPAWNING)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether patrols can spawn.");
        lore.add("");
        lore.add("Default value is: true");
        doPatrolSpawningmeta.setLore(lore);
        doPatrolSpawning.setItemMeta(doPatrolSpawningmeta);


        return doPatrolSpawning;
    }

}
