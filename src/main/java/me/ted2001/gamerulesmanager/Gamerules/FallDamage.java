package me.ted2001.gamerulesmanager.Gamerules;

import me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class FallDamage {

    public FallDamage(){}
    private WorldSelectorListener world;
    public ItemStack fallDamage(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack fallDamage = new ItemStack(Material.DIAMOND_BOOTS);

        ItemMeta fallDamagemeta = fallDamage.getItemMeta();

        fallDamagemeta.addEnchant(Enchantment.PROTECTION_FALL,10,true);
        fallDamagemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS);
        fallDamagemeta.setDisplayName(ChatColor.RED + "fallDamage");
        if(Boolean.TRUE.equals(playerworld.getGameRuleValue(GameRule.FALL_DAMAGE))){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the player should take");
        lore.add("fall damage ");
        lore.add("");
        lore.add("Default value is: true");
        fallDamagemeta.setLore(lore);
        fallDamage.setItemMeta(fallDamagemeta);

        return fallDamage;
    }


}
