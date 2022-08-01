package me.ted2001.gamerulesmanager.Listeners;


import me.ted2001.gamerulesmanager.GUI.GUI;
import me.ted2001.gamerulesmanager.Gamerules.GameruleGetter;
import me.ted2001.gamerulesmanager.CopyGamerules;
import me.ted2001.gamerulesmanager.GameruleManager;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

import static me.ted2001.gamerulesmanager.GameruleManager.Serverversion;
import static me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener.WorldSelected;



@SuppressWarnings({"IfStatementWithIdenticalBranches", "ConstantConditions", "RedundantSuppression"})
public class GuiListener implements Listener {

    String prefix = ChatColor.RED + "" + "[" + ChatColor.GREEN + "" +"Ultimate Gamerules  Manager" + ChatColor.RED + "" + "] ";

    public static World Worldcopied = null;
    private final CopyGamerules[] GamerulesList = new CopyGamerules[40];
    private final GUI GUI = new GUI();
    public final WorldSelectorListener world = new WorldSelectorListener();


    @SuppressWarnings("rawtypes")
    private void booleanGameruleSet(GameRule<Boolean> rule, boolean value, World world, Player p){
        world.setGameRule(rule,value);
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
    }



    @EventHandler
    public void onGuiClick(InventoryClickEvent e) {

        try {
            if (e.getView().getTitle().contains(ChatColor.DARK_PURPLE + "Gamerule Manager" + ChatColor.AQUA + " ")) {
                //players can not move items
                e.setCancelled(true);
                Inventory gui = e.getClickedInventory();
                Player p = (Player) e.getWhoClicked();
                World selectedworld = WorldSelected;
                GameruleGetter Getter = new GameruleGetter(selectedworld);
                if (e.getCurrentItem() == null)
                    return;
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "announceAdvancements")) {
                    if (selectedworld.getGameRuleValue(GameRule.ANNOUNCE_ADVANCEMENTS)) {
                        booleanGameruleSet(GameRule.ANNOUNCE_ADVANCEMENTS, false, selectedworld, p);
                        gui.setItem(0, Getter.announceAdvancements());
                    } else {
                        booleanGameruleSet(GameRule.ANNOUNCE_ADVANCEMENTS, true, selectedworld, p);
                        gui.setItem(0, Getter.announceAdvancements());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "commandBlockOutput")) {
                    if (selectedworld.getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT)) {
                        booleanGameruleSet(GameRule.COMMAND_BLOCK_OUTPUT, false, selectedworld, p);
                        gui.setItem(1, Getter.commandBlockOutput());
                    } else {
                        booleanGameruleSet(GameRule.COMMAND_BLOCK_OUTPUT, true, selectedworld, p);
                        gui.setItem(1, Getter.commandBlockOutput());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "disableElytraMovementCheck")) {
                    if (selectedworld.getGameRuleValue(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK)) {
                        booleanGameruleSet(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, false, selectedworld, p);
                        gui.setItem(2, Getter.disableElytraMovementCheck());
                    } else {
                        booleanGameruleSet(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, true, selectedworld, p);
                        gui.setItem(2, Getter.disableElytraMovementCheck());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doDaylightCyclemeta")){
                    if (selectedworld.getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                        booleanGameruleSet(GameRule.DO_DAYLIGHT_CYCLE, false, selectedworld, p);
                        gui.setItem(3, Getter.daylightCycle());
                    } else {
                        booleanGameruleSet(GameRule.DO_DAYLIGHT_CYCLE, true, selectedworld, p);
                        gui.setItem(3, Getter.daylightCycle());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doEntityDrops")){
                    if (selectedworld.getGameRuleValue(GameRule.DO_ENTITY_DROPS)) {
                        booleanGameruleSet(GameRule.DO_ENTITY_DROPS, false, selectedworld, p);
                        gui.setItem(4, Getter.entityDrops());
                    } else {
                        booleanGameruleSet(GameRule.DO_ENTITY_DROPS, true, selectedworld, p);
                        gui.setItem(4, Getter.entityDrops());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doFireTick")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                        booleanGameruleSet(GameRule.DO_FIRE_TICK, false, selectedworld, p);
                        gui.setItem(5, Getter.doFireTick());
                    } else {
                        booleanGameruleSet(GameRule.DO_FIRE_TICK, true, selectedworld, p);
                        gui.setItem(5, Getter.doFireTick());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "mobGriefing")) {
                    if (selectedworld.getGameRuleValue(GameRule.MOB_GRIEFING)) {
                        booleanGameruleSet(GameRule.MOB_GRIEFING, false, selectedworld, p);
                        gui.setItem(6, Getter.mobGriefing());
                    } else {
                        booleanGameruleSet(GameRule.MOB_GRIEFING, true, selectedworld, p);
                        gui.setItem(6, Getter.mobGriefing());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doMobSpawning")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_MOB_SPAWNING, false, selectedworld, p);
                        gui.setItem(7, Getter.doMobSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_MOB_SPAWNING, true, selectedworld, p);
                        gui.setItem(7, Getter.doMobSpawning());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doMobLoot")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                        booleanGameruleSet(GameRule.DO_MOB_LOOT, false, selectedworld, p);
                        gui.setItem(8, Getter.doMobLoot());
                    } else {
                        booleanGameruleSet(GameRule.DO_MOB_LOOT, true, selectedworld, p);
                        gui.setItem(8, Getter.doMobLoot());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doTileDrops")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_TILE_DROPS)) {
                        booleanGameruleSet(GameRule.DO_TILE_DROPS, false, selectedworld, p);
                        gui.setItem(9, Getter.doTileDrops());
                    } else {
                        booleanGameruleSet(GameRule.DO_TILE_DROPS, true, selectedworld, p);
                        gui.setItem(9, Getter.doTileDrops());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "keepInventory")) {
                    if (selectedworld.getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                        booleanGameruleSet(GameRule.KEEP_INVENTORY, false, selectedworld, p);
                        gui.setItem(10, Getter.keepInventory());
                    } else {
                        booleanGameruleSet(GameRule.KEEP_INVENTORY, true, selectedworld, p);
                        gui.setItem(10, Getter.keepInventory());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "naturalRegeneration")) {
                    if (selectedworld.getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                        booleanGameruleSet(GameRule.NATURAL_REGENERATION, false, selectedworld, p);
                        gui.setItem(11, Getter.naturalRegeneration());
                    } else {
                        booleanGameruleSet(GameRule.NATURAL_REGENERATION, true, selectedworld, p);
                        gui.setItem(11, Getter.naturalRegeneration());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "logAdminCommands")) {
                    if (selectedworld.getGameRuleValue(GameRule.LOG_ADMIN_COMMANDS)) {
                        booleanGameruleSet(GameRule.LOG_ADMIN_COMMANDS, false, selectedworld, p);
                        gui.setItem(12, Getter.logAdminCommands());
                    } else {
                        booleanGameruleSet(GameRule.LOG_ADMIN_COMMANDS, true, selectedworld, p);
                        gui.setItem(12, Getter.logAdminCommands());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "showDeathMessages")) {
                    if (selectedworld.getGameRuleValue(GameRule.SHOW_DEATH_MESSAGES)) {
                        booleanGameruleSet(GameRule.SHOW_DEATH_MESSAGES, false, selectedworld, p);
                        gui.setItem(13, Getter.showDeathMessages());
                    } else {
                        booleanGameruleSet(GameRule.SHOW_DEATH_MESSAGES, true, selectedworld, p);
                        gui.setItem(13, Getter.showDeathMessages());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "sendCommandFeedback")) {
                    if (selectedworld.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK)) {
                        booleanGameruleSet(GameRule.SEND_COMMAND_FEEDBACK, false, selectedworld, p);
                        gui.setItem(14, Getter.sendCommandFeedback());
                    } else {
                        booleanGameruleSet(GameRule.SEND_COMMAND_FEEDBACK, true, selectedworld, p);
                        gui.setItem(14, Getter.sendCommandFeedback());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "reducedDebugInfo")) {
                    if (selectedworld.getGameRuleValue(GameRule.REDUCED_DEBUG_INFO)) {
                        booleanGameruleSet(GameRule.REDUCED_DEBUG_INFO, false, selectedworld, p);
                        gui.setItem(16, Getter.reducedDebugInfo());
                    } else {
                        booleanGameruleSet(GameRule.REDUCED_DEBUG_INFO, true, selectedworld, p);
                        gui.setItem(16, Getter.reducedDebugInfo());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "spectatorsGenerateChunks")) {
                    if (selectedworld.getGameRuleValue(GameRule.SPECTATORS_GENERATE_CHUNKS)) {
                        booleanGameruleSet(GameRule.SPECTATORS_GENERATE_CHUNKS, false, selectedworld, p);
                        gui.setItem(17, Getter.spectatorsGenerateChunks());
                    } else {
                        booleanGameruleSet(GameRule.SPECTATORS_GENERATE_CHUNKS, true, selectedworld, p);
                        gui.setItem(17, Getter.spectatorsGenerateChunks());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doWeatherCycle")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                        booleanGameruleSet(GameRule.DO_WEATHER_CYCLE, false, selectedworld, p);
                        gui.setItem(19, Getter.doWeatherCycle());
                    } else {
                        booleanGameruleSet(GameRule.DO_WEATHER_CYCLE, true, selectedworld, p);
                        gui.setItem(19, Getter.doWeatherCycle());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doLimitedCrafting")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_LIMITED_CRAFTING)) {
                        booleanGameruleSet(GameRule.DO_LIMITED_CRAFTING, false, selectedworld, p);
                        gui.setItem(21, Getter.doLimitedCrafting());
                    } else {
                        booleanGameruleSet(GameRule.DO_LIMITED_CRAFTING, true, selectedworld, p);
                        gui.setItem(21, Getter.doLimitedCrafting());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "randomTickSpeed")) {
                    p.closeInventory();
                    valueReceiver(p,"randomTickSpeed");
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "spawnRadius")) {
                    p.closeInventory();
                    valueReceiver(p,"spawnRadius");
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "maxEntityCramming")) {
                    p.closeInventory();
                    valueReceiver(p,"maxEntityCramming");
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "maxCommandChainLength")) {
                    p.closeInventory();
                    valueReceiver(p,"maxCommandChainLength");
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "disableRaids")) {
                    if (selectedworld.getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                        booleanGameruleSet(GameRule.DISABLE_RAIDS, false, selectedworld, p);
                        gui.setItem(23, Getter.disableRaids());
                } else {
                        booleanGameruleSet(GameRule.DISABLE_RAIDS, true, selectedworld, p);
                        gui.setItem(23, Getter.disableRaids());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doInsomnia")){
                    if (selectedworld.getGameRuleValue(GameRule.DO_INSOMNIA)) {
                        booleanGameruleSet(GameRule.DO_INSOMNIA, false, selectedworld, p);
                        gui.setItem(24, Getter.doInsomnia());
                    }else {
                        booleanGameruleSet(GameRule.DO_INSOMNIA, true, selectedworld, p);
                        gui.setItem(24, Getter.doInsomnia());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doImmediateRespawn")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN)) {
                        booleanGameruleSet(GameRule.DO_IMMEDIATE_RESPAWN, false, selectedworld, p);
                        gui.setItem(25, Getter.doImmediateRespawn());
                    } else {
                        booleanGameruleSet(GameRule.DO_IMMEDIATE_RESPAWN, true, selectedworld, p);
                        gui.setItem(25, Getter.doImmediateRespawn());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "drowningDamage")) {
                    if (selectedworld.getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                        booleanGameruleSet(GameRule.DROWNING_DAMAGE, false, selectedworld, p);
                        gui.setItem(26, Getter.drowningDamage());
                    } else {
                        booleanGameruleSet(GameRule.DROWNING_DAMAGE, true, selectedworld, p);
                        gui.setItem(26, Getter.drowningDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "fireDamage")) {
                    if (selectedworld.getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                        booleanGameruleSet(GameRule.FIRE_DAMAGE, false, selectedworld, p);
                        gui.setItem(27, Getter.fireDamage());
                    } else {
                        booleanGameruleSet(GameRule.FIRE_DAMAGE, true, selectedworld, p);
                        gui.setItem(27, Getter.fireDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "fallDamage")) {
                    if (selectedworld.getGameRuleValue(GameRule.FALL_DAMAGE)) {
                        booleanGameruleSet(GameRule.FALL_DAMAGE, false, selectedworld, p);
                        gui.setItem(28, Getter.fallDamage());
                    } else {
                        booleanGameruleSet(GameRule.FALL_DAMAGE, true, selectedworld, p);
                        gui.setItem(28, Getter.fallDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doPatrolSpawning")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_PATROL_SPAWNING, false, selectedworld, p);
                        gui.setItem(29, Getter.doPatrolSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_PATROL_SPAWNING, true, selectedworld, p);
                        gui.setItem(29, Getter.doPatrolSpawning());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doTraderSpawning")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_TRADER_SPAWNING, false, selectedworld, p);
                        gui.setItem(30, Getter.doTraderSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_TRADER_SPAWNING, true, selectedworld, p);
                        gui.setItem(30, Getter.doTraderSpawning());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "universalAnger")) {
                    if (selectedworld.getGameRuleValue(GameRule.UNIVERSAL_ANGER)) {
                        booleanGameruleSet(GameRule.UNIVERSAL_ANGER, false, selectedworld, p);
                        gui.setItem(31, Getter.universalAnger());
                    } else {
                        booleanGameruleSet(GameRule.UNIVERSAL_ANGER, true, selectedworld, p);
                        gui.setItem(31, Getter.universalAnger());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "forgiveDeadPlayers")) {
                    if (selectedworld.getGameRuleValue(GameRule.FORGIVE_DEAD_PLAYERS)) {
                        booleanGameruleSet(GameRule.FORGIVE_DEAD_PLAYERS, false, selectedworld, p);
                        gui.setItem(32, Getter.forgiveDeadPlayers());
                    } else {
                        booleanGameruleSet(GameRule.FORGIVE_DEAD_PLAYERS, true, selectedworld, p);
                        gui.setItem(32, Getter.forgiveDeadPlayers());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "freezeDamage")) {
                    if (selectedworld.getGameRuleValue(GameRule.FREEZE_DAMAGE)) {
                        booleanGameruleSet(GameRule.FREEZE_DAMAGE, false, selectedworld, p);
                        gui.setItem(33, Getter.freezeDamage());
                    } else {
                        booleanGameruleSet(GameRule.FREEZE_DAMAGE, true, selectedworld, p);
                        gui.setItem(33, Getter.freezeDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "playersSleepingPercentage")) {
                    p.closeInventory();
                    valueReceiver(p,"playersSleepingPercentage");
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doWardenSpawning")) {
                    if (selectedworld.getGameRuleValue(GameRule.DO_WARDEN_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_WARDEN_SPAWNING, false, selectedworld, p);
                        gui.setItem(35, Getter.doWardenSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_WARDEN_SPAWNING, true, selectedworld, p);
                        gui.setItem(35, Getter.doWardenSpawning());
                    }
                //get back option
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Get Back in World Selection.")) {
                        p.openInventory(GUI.guiBuilder(p));
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
                //exit option
                }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "EXIT")) {
                    p.closeInventory();
                    if(Integer.parseInt(Serverversion) >= 14)
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE, 1,1);
                    else
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1,1);
                }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Reset all " + ChatColor.YELLOW + "Gamerules")) {
                    resetGamerules(selectedworld);
                    p.openInventory(GUI.gameruleSetterGui(p,selectedworld));
                    p.playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1,1);

                //copy option
                }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_BLUE + "Copy " + ChatColor.YELLOW + "Gamerules")) {
                    copyGamerules(selectedworld);
                    p.openInventory(GUI.guiBuilder(p));
                    if(Integer.parseInt(Serverversion) >= 14)
                        p.playSound(p.getLocation(), Sound.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, 1,1);
                    else
                        p.playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1,1);
                //paste option
                }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Paste " + ChatColor.YELLOW + "Gamerules")) {
                    if(Worldcopied != null) {
                        for (int i = 0; i < WorldSelected.getGameRules().length; i++){
                            GameRule gamerule = GameRule.getByName(GamerulesList[i].getGameRule());
                            int intvalue;
                            boolean booleanvalue;
                            try {
                                intvalue = Integer.parseInt(GamerulesList[i].getValue());
                                WorldSelected.setGameRule(gamerule, intvalue);
                            }catch (NumberFormatException ex){
                                booleanvalue = Boolean.parseBoolean(GamerulesList[i].getValue());
                                WorldSelected.setGameRule(gamerule, booleanvalue);
                            }
                        }
                        if(Integer.parseInt(Serverversion) >= 14)
                            p.playSound(p.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1,1);
                        else
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1,1);
                        p.openInventory(GUI.gameruleSetterGui(p,selectedworld));
                        p.sendMessage(prefix + ChatColor.YELLOW +"You copied all " + ChatColor.AQUA + "Gamerules " +
                                ChatColor.YELLOW +"from "  + ChatColor.BLUE + Worldcopied.getName()
                                + ChatColor.YELLOW + " to " + ChatColor.RED + WorldSelected.getName() + ChatColor.YELLOW + ".");
                    }else{
                        p.sendMessage(prefix + ChatColor.RED + "" + ChatColor.BOLD +"You didn't copy any world.");
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1,1);
                    }
                }



            }
            //for 1.13 NullPointerException if you click air
        }catch (NullPointerException ignored) { }
    }

    private void valueReceiver(Player p, String gamerule) {
        World w = WorldSelected;
        new AnvilGUI.Builder().onComplete((player, text) -> {
                    int value;
                    try{
                        value = Integer.parseInt(text);
                    }catch (NumberFormatException ex){
                        player.sendMessage(prefix + ChatColor.YELLOW + "You didn't type an " + ChatColor.RED + "integer number" + ChatColor.YELLOW +".");
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                        return AnvilGUI.Response.openInventory(GUI.gameruleSetterGui(p,WorldSelected));
                    }
                    switch (gamerule) {
                        case "randomTickSpeed":
                            integerGameruleSetter(GameRule.RANDOM_TICK_SPEED, value, w, p);
                            return AnvilGUI.Response.openInventory(GUI.gameruleSetterGui(p,WorldSelected));
                        case "spawnRadius":
                            integerGameruleSetter(GameRule.SPAWN_RADIUS, value, w, p);
                            return AnvilGUI.Response.openInventory(GUI.gameruleSetterGui(p,WorldSelected));
                        case "maxEntityCramming":
                            integerGameruleSetter(GameRule.MAX_ENTITY_CRAMMING, value, w, p);
                            return AnvilGUI.Response.openInventory(GUI.gameruleSetterGui(p,WorldSelected));
                        case "maxCommandChainLength":
                            integerGameruleSetter(GameRule.MAX_COMMAND_CHAIN_LENGTH, value, w, p);
                            return AnvilGUI.Response.openInventory(GUI.gameruleSetterGui(p,WorldSelected));
                        case "playersSleepingPercentage":
                                integerGameruleSetter(GameRule.PLAYERS_SLEEPING_PERCENTAGE, value, w, p);
                                return AnvilGUI.Response.openInventory(GUI.gameruleSetterGui(p,WorldSelected));
                        }
                    return null;
                })
                .text("Read paper's info.")
                .itemLeft(new ItemStack(getItem()))
                .title("Enter your value.")
                .plugin(GameruleManager.getPlugin())
                .open(p);
    }

    private void integerGameruleSetter(GameRule<Integer> gamerule, int value, World w,Player p){
        w.setGameRule(gamerule, value);
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
    }

    private void resetGamerules(World world){
        String[] gamerulesNames = world.getGameRules();
        for (String name : gamerulesNames) {
            GameRule gamerule;
            if (GameRule.getByName(name).getType() == Boolean.class) {
                gamerule = GameRule.getByName(name);
                Boolean defaultValue = (Boolean) world.getGameRuleDefault(gamerule);
                world.setGameRule(gamerule, defaultValue);
            } else if (GameRule.getByName(name).getType() == Integer.class) {
                gamerule = GameRule.getByName(name);
                int defaultValue = (Integer) world.getGameRuleDefault(gamerule);
                world.setGameRule(gamerule, defaultValue);
            }
        }
    }

    private void copyGamerules(World world){
        String[] gamerulesNames = world.getGameRules();
        Arrays.sort(gamerulesNames);
        for (int i =0; i < gamerulesNames.length; i++) {
            String gamerule = gamerulesNames[i];
            String value = world.getGameRuleValue(GameRule.getByName(gamerulesNames[i])).toString();
            GamerulesList[i] = new CopyGamerules(gamerule, value);
        }
        Worldcopied = world;
    }

    private ItemStack getItem(){

        ArrayList<String> lore = new ArrayList<>();
        ItemStack paper = new ItemStack(Material.PAPER);
        ItemMeta papermeta = paper.getItemMeta();
        papermeta.setDisplayName("Read paper's info.");
        lore.add("Rename this to your wanted value.");
        lore.add("Only integer numbers.");
        papermeta.setLore(lore);
        paper.setItemMeta(papermeta);
        return paper;


    }




}
