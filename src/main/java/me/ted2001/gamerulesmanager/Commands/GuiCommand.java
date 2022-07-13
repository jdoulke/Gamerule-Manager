package me.ted2001.gamerulesmanager.Commands;


import me.ted2001.gamerulesmanager.GUI.GUI;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;





public class GuiCommand implements CommandExecutor {

    private GUI GUI = new GUI();

    public GuiCommand(){}

    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull  Command command,@NotNull  String label, String[] args) {
        if(sender instanceof Player ){
            //get player
            Player p = (Player) sender;
            if(p.hasPermission("gamerulemanager.use")) {
                p.openInventory(GUI.guiBuilder(p));
                p.playSound(p,Sound.ENTITY_VILLAGER_WORK_WEAPONSMITH, 1,1);
            }else
                p.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                p.playSound(p, Sound.ENTITY_VILLAGER_NO, 1,1);
        }

        return false;
    }






}
