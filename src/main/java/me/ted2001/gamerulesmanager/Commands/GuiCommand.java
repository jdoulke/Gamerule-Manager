package me.ted2001.gamerulesmanager.Commands;


import me.ted2001.gamerulesmanager.GUI.GUI;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;

import static me.ted2001.gamerulesmanager.GameruleManager.Serverversion;


public class GuiCommand implements CommandExecutor {

    private final GUI GUI = new GUI();


    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull  Command command,@NotNull  String label, String[] args) {
        if(sender instanceof Player ){
            //get player
            Player p = (Player) sender;
            World world = p.getWorld();
              if(p.hasPermission("gamerulemanager.use")) {
                p.openInventory(GUI.guiBuilder(p));
                if(Integer.parseInt(Serverversion) >= 14)
                    p.playSound(p.getLocation(),Sound.ENTITY_VILLAGER_WORK_WEAPONSMITH, 1,1);
                else
                    p.playSound(p.getLocation(),Sound.ENTITY_VILLAGER_YES, 1,1);
            }else
                p.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1,1);
        }

        return false;
    }






}
