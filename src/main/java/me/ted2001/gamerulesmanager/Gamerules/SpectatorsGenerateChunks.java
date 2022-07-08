package me.ted2001.gamerulesmanager.Gamerules;

import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SpectatorsGenerateChunks {


    public SpectatorsGenerateChunks() {

    }

    public ItemStack spectatorsGenerateChunks(CommandSender sender) {

        Player p = (Player) sender;

        World playerworld = p.getWorld();

        ArrayList<String> lore = new ArrayList<>();

        ItemStack spectatorsGenerateChunks = new ItemStack(Material.ENDER_EYE);

        ItemMeta spectatorsGenerateChunksmeta = spectatorsGenerateChunks.getItemMeta();

        spectatorsGenerateChunksmeta.setDisplayName(ChatColor.RED + "spectatorsGenerateChunks");
        if (playerworld.getGameRuleValue(GameRule.SPECTATORS_GENERATE_CHUNKS)) {
            lore.add("Gamerule is currently set to: " + ChatColor.GREEN + "" + ChatColor.BOLD + "True");

        } else {
            lore.add("Gamerule is currently set to: " + ChatColor.RED + "" + ChatColor.BOLD + "False");
        }
        lore.add("");
        lore.add("Whether players in spectator");
        lore.add("mode can generate chunks.");
        lore.add("");
        lore.add("Default value is: true");
        spectatorsGenerateChunksmeta.setLore(lore);
        spectatorsGenerateChunks.setItemMeta(spectatorsGenerateChunksmeta);

        return spectatorsGenerateChunks;
    }
}
