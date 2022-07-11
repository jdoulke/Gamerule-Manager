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

public class DoTileDrops {

    public DoTileDrops(){

    }
    private WorldSelectorListener world = new WorldSelectorListener();
    public ItemStack doTileDrops(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = world.getWorldSelected();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack doTileDrops = new ItemStack(Material.OAK_LOG);

        ItemMeta doTileDropsmeta = doTileDrops.getItemMeta();

        doTileDropsmeta.setDisplayName(ChatColor.RED + "doTileDrops");
        if(playerworld.getGameRuleValue(GameRule.DO_TILE_DROPS)){
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        }else{
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether blocks should");
        lore.add("have drops .");
        lore.add("");
        lore.add("Default value is: true");
        doTileDropsmeta.setLore(lore);
        doTileDrops.setItemMeta(doTileDropsmeta);


        return doTileDrops;
    }

}
