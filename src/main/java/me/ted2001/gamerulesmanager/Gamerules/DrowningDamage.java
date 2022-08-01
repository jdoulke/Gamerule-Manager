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

public class DrowningDamage {


    public DrowningDamage(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack drowningDamage(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack drowningDamage = new ItemStack(Material.WATER_BUCKET);

        ItemMeta drowningDamagemeta = drowningDamage.getItemMeta();

        drowningDamagemeta.setDisplayName(ChatColor.RED + "drowningDamage");
        drowningDamagemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.DROWNING_DAMAGE)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the player should take");
        lore.add("damage when drowning.");
        lore.add("");
        lore.add("Default value is: true");
        drowningDamagemeta.setLore(lore);
        drowningDamage.setItemMeta(drowningDamagemeta);


        return drowningDamage;
    }

}
