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

public class DisableElytraMovementCheck {

    public DisableElytraMovementCheck(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack DisableElytraMovementCheck(World w){


        World playerworld = w;

        ArrayList<String> lore = new ArrayList<>();

        ItemStack DisableElytraMovementCheck = new ItemStack(Material.ELYTRA,1);
        ItemMeta DisableElytraMovementCheckmeta = DisableElytraMovementCheck.getItemMeta();
        DisableElytraMovementCheckmeta.setDisplayName(ChatColor.RED + "disableElytraMovementCheck");
        if(playerworld.getGameRuleValue(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the server should");
        lore.add("skip checking player speed");
        lore.add("when the player is wearing elytra.");
        lore.add("");
        lore.add("Default value is: false");
        DisableElytraMovementCheckmeta.setLore(lore);
        DisableElytraMovementCheck.setItemMeta(DisableElytraMovementCheckmeta);


        return DisableElytraMovementCheck;
    }

}
