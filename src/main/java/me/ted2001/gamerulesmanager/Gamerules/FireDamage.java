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

public class FireDamage {

    public FireDamage(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack fireDamage(World w) {


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack fireDamage = new ItemStack(Material.LAVA_BUCKET);

        ItemMeta fireDamagemeta = fireDamage.getItemMeta();

        fireDamagemeta.setDisplayName(ChatColor.RED + "fireDamage");
        fireDamagemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        if(playerworld.getGameRuleValue(GameRule.FIRE_DAMAGE)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the player should take");
        lore.add("damage in fire, lava, campfires,");
        lore.add("or on magma blocks.");
        lore.add("");
        lore.add("Default value is: true");
        fireDamagemeta.setLore(lore);
        fireDamage.setItemMeta(fireDamagemeta);


        return fireDamage;
    }


}
