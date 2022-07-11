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

public class RandomTickSpeed {

    public RandomTickSpeed(){

    }
    private final WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack randomTickSpeed(CommandSender sender){
        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();



        ArrayList<String> lore = new ArrayList<>();

        ItemStack randomTickSpeed = new ItemStack(Material.WHEAT,1);
        ItemMeta randomTickSpeedsmeta = randomTickSpeed.getItemMeta();
        randomTickSpeedsmeta.setDisplayName(ChatColor.RED + "randomTickSpeed");
        lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + playerworld.getGameRuleValue(GameRule.RANDOM_TICK_SPEED));
        lore.add("");
        lore.add("How often a random block");
        lore.add("tick occurs such as plant growth");
        lore.add("per chunk sectionper game tick.");
        lore.add("");
        lore.add("Default value is: 3");
        randomTickSpeedsmeta.setLore(lore);
        randomTickSpeed.setItemMeta(randomTickSpeedsmeta);

        return randomTickSpeed;
    }
}
