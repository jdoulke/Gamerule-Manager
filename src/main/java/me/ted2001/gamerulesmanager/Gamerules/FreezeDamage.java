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

public class FreezeDamage {

    public FreezeDamage(){}
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack freezeDamage(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack freezeDamage = new ItemStack(Material.BLUE_ICE);

        ItemMeta freezeDamagemeta = freezeDamage.getItemMeta();


        freezeDamagemeta.setDisplayName(ChatColor.RED + "freezeDamage");
        if(playerworld.getGameRuleValue(GameRule.FREEZE_DAMAGE)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");
        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether the player should take");
        lore.add("damage when inside powder snow.");
        lore.add("");
        lore.add("Default value is: true");
        freezeDamagemeta.setLore(lore);
        freezeDamage.setItemMeta(freezeDamagemeta);


        return freezeDamage;
    }

}
