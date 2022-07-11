package me.ted2001.gamerulesmanager.Listeners;


import me.ted2001.gamerulesmanager.GUI.GUI;
import me.ted2001.gamerulesmanager.Gamerules.*;
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

import static me.ted2001.gamerulesmanager.Listeners.WorldSelectorListener.WorldSelected;

@SuppressWarnings({"IfStatementWithIdenticalBranches", "ConstantConditions", "RedundantSuppression"})
public class GuiListener implements Listener {

    String prefix = ChatColor.RED + "" + "[" + ChatColor.GREEN + "" +"Gamerule  Manager" + ChatColor.RED + "" + "] ";

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
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "" + ChatColor.BOLD + "Gamerule GUI Manager")) {
                //players can not move items
                e.setCancelled(true);
                Inventory gui = e.getClickedInventory();
                Player p = (Player) e.getWhoClicked();
                p.sendMessage("geia");
                p.sendMessage(WorldSelected.getName());
                World playerworld = WorldSelected;
                GameruleGetter Getter = new GameruleGetter(playerworld);
                if (e.getCurrentItem() == null)
                    return;
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "announceAdvancements")) {
                    if (playerworld.getGameRuleValue(GameRule.ANNOUNCE_ADVANCEMENTS)) {
                        booleanGameruleSet(GameRule.ANNOUNCE_ADVANCEMENTS, false, playerworld, p);
                        gui.setItem(0, Getter.announceAdvancements());
                    } else {
                        booleanGameruleSet(GameRule.ANNOUNCE_ADVANCEMENTS, true, playerworld, p);
                        gui.setItem(0, Getter.announceAdvancements());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "commandBlockOutput")) {
                    if (playerworld.getGameRuleValue(GameRule.COMMAND_BLOCK_OUTPUT)) {
                        booleanGameruleSet(GameRule.COMMAND_BLOCK_OUTPUT, false, playerworld, p);
                        gui.setItem(1, Getter.commandBlockOutput());
                    } else {
                        booleanGameruleSet(GameRule.COMMAND_BLOCK_OUTPUT, true, playerworld, p);
                        gui.setItem(1, Getter.commandBlockOutput());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "disableElytraMovementCheck")) {
                    if (playerworld.getGameRuleValue(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK)) {
                        booleanGameruleSet(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, false, playerworld, p);
                        gui.setItem(2, Getter.disableElytraMovementCheck());
                    } else {
                        booleanGameruleSet(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, true, playerworld, p);
                        gui.setItem(2, Getter.disableElytraMovementCheck());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doDaylightCyclemeta")){
                    if (playerworld.getGameRuleValue(GameRule.DO_DAYLIGHT_CYCLE)) {
                        booleanGameruleSet(GameRule.DO_DAYLIGHT_CYCLE, false, playerworld, p);
                        gui.setItem(3, Getter.daylightCycle());
                    } else {
                        booleanGameruleSet(GameRule.DO_DAYLIGHT_CYCLE, true, playerworld, p);
                        gui.setItem(3, Getter.daylightCycle());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doEntityDrops")){
                    if (playerworld.getGameRuleValue(GameRule.DO_ENTITY_DROPS)) {
                        booleanGameruleSet(GameRule.DO_ENTITY_DROPS, false, playerworld, p);
                        gui.setItem(4, Getter.entityDrops());
                    } else {
                        booleanGameruleSet(GameRule.DO_ENTITY_DROPS, true, playerworld, p);
                        gui.setItem(4, Getter.entityDrops());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doFireTick")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_FIRE_TICK)) {
                        booleanGameruleSet(GameRule.DO_FIRE_TICK, false, playerworld, p);
                        gui.setItem(5, Getter.doFireTick());
                    } else {
                        booleanGameruleSet(GameRule.DO_FIRE_TICK, true, playerworld, p);
                        gui.setItem(5, Getter.doFireTick());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "mobGriefing")) {
                    if (playerworld.getGameRuleValue(GameRule.MOB_GRIEFING)) {
                        booleanGameruleSet(GameRule.MOB_GRIEFING, false, playerworld, p);
                        gui.setItem(6, Getter.mobGriefing());
                    } else {
                        booleanGameruleSet(GameRule.MOB_GRIEFING, true, playerworld, p);
                        gui.setItem(6, Getter.mobGriefing());
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doMobSpawning")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_MOB_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_MOB_SPAWNING, false, playerworld, p);
                        gui.setItem(7, Getter.doMobSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_MOB_SPAWNING, true, playerworld, p);
                        gui.setItem(7, Getter.doMobSpawning());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doMobLoot")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_MOB_LOOT)) {
                        booleanGameruleSet(GameRule.DO_MOB_LOOT, false, playerworld, p);
                        gui.setItem(8, Getter.doMobLoot());
                    } else {
                        booleanGameruleSet(GameRule.DO_MOB_LOOT, true, playerworld, p);
                        gui.setItem(8, Getter.doMobLoot());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doTileDrops")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_TILE_DROPS)) {
                        booleanGameruleSet(GameRule.DO_TILE_DROPS, false, playerworld, p);
                        gui.setItem(9, Getter.doTileDrops());
                    } else {
                        booleanGameruleSet(GameRule.DO_TILE_DROPS, true, playerworld, p);
                        gui.setItem(9, Getter.doTileDrops());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "keepInventory")) {
                    if (playerworld.getGameRuleValue(GameRule.KEEP_INVENTORY)) {
                        booleanGameruleSet(GameRule.KEEP_INVENTORY, false, playerworld, p);
                        gui.setItem(10, Getter.keepInventory());
                    } else {
                        booleanGameruleSet(GameRule.KEEP_INVENTORY, true, playerworld, p);
                        gui.setItem(10, Getter.keepInventory());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "naturalRegeneration")) {
                    if (playerworld.getGameRuleValue(GameRule.NATURAL_REGENERATION)) {
                        booleanGameruleSet(GameRule.NATURAL_REGENERATION, false, playerworld, p);
                        gui.setItem(11, Getter.naturalRegeneration());
                    } else {
                        booleanGameruleSet(GameRule.NATURAL_REGENERATION, true, playerworld, p);
                        gui.setItem(11, Getter.naturalRegeneration());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "logAdminCommands")) {
                    if (playerworld.getGameRuleValue(GameRule.LOG_ADMIN_COMMANDS)) {
                        booleanGameruleSet(GameRule.LOG_ADMIN_COMMANDS, false, playerworld, p);
                        gui.setItem(12, Getter.logAdminCommands());
                    } else {
                        booleanGameruleSet(GameRule.LOG_ADMIN_COMMANDS, true, playerworld, p);
                        gui.setItem(12, Getter.logAdminCommands());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "showDeathMessages")) {
                    if (playerworld.getGameRuleValue(GameRule.SHOW_DEATH_MESSAGES)) {
                        booleanGameruleSet(GameRule.SHOW_DEATH_MESSAGES, false, playerworld, p);
                        gui.setItem(13, Getter.showDeathMessages());
                    } else {
                        booleanGameruleSet(GameRule.SHOW_DEATH_MESSAGES, true, playerworld, p);
                        gui.setItem(13, Getter.showDeathMessages());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "sendCommandFeedback")) {
                    if (playerworld.getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK)) {
                        booleanGameruleSet(GameRule.SEND_COMMAND_FEEDBACK, false, playerworld, p);
                        gui.setItem(14, Getter.sendCommandFeedback());
                    } else {
                        booleanGameruleSet(GameRule.SEND_COMMAND_FEEDBACK, true, playerworld, p);
                        gui.setItem(14, Getter.sendCommandFeedback());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "reducedDebugInfo")) {
                    if (playerworld.getGameRuleValue(GameRule.REDUCED_DEBUG_INFO)) {
                        booleanGameruleSet(GameRule.REDUCED_DEBUG_INFO, false, playerworld, p);
                        gui.setItem(16, Getter.reducedDebugInfo());
                    } else {
                        booleanGameruleSet(GameRule.REDUCED_DEBUG_INFO, true, playerworld, p);
                        gui.setItem(16, Getter.reducedDebugInfo());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "spectatorsGenerateChunks")) {
                    if (playerworld.getGameRuleValue(GameRule.SPECTATORS_GENERATE_CHUNKS)) {
                        booleanGameruleSet(GameRule.SPECTATORS_GENERATE_CHUNKS, false, playerworld, p);
                        gui.setItem(17, Getter.spectatorsGenerateChunks());
                    } else {
                        booleanGameruleSet(GameRule.SPECTATORS_GENERATE_CHUNKS, true, playerworld, p);
                        gui.setItem(17, Getter.spectatorsGenerateChunks());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doWeatherCycle")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_WEATHER_CYCLE)) {
                        booleanGameruleSet(GameRule.DO_WEATHER_CYCLE, false, playerworld, p);
                        gui.setItem(19, Getter.doWeatherCycle());
                    } else {
                        booleanGameruleSet(GameRule.DO_WEATHER_CYCLE, true, playerworld, p);
                        gui.setItem(19, Getter.doWeatherCycle());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doLimitedCrafting")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_LIMITED_CRAFTING)) {
                        booleanGameruleSet(GameRule.DO_LIMITED_CRAFTING, false, playerworld, p);
                        gui.setItem(21, Getter.doLimitedCrafting());
                    } else {
                        booleanGameruleSet(GameRule.DO_LIMITED_CRAFTING, true, playerworld, p);
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
                    if (playerworld.getGameRuleValue(GameRule.DISABLE_RAIDS)) {
                        booleanGameruleSet(GameRule.DISABLE_RAIDS, false, playerworld, p);
                        gui.setItem(23, Getter.disableRaids());
                } else {
                        booleanGameruleSet(GameRule.DISABLE_RAIDS, true, playerworld, p);
                        gui.setItem(23, Getter.disableRaids());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doInsomnia")){
                    if (playerworld.getGameRuleValue(GameRule.DO_INSOMNIA)) {
                        booleanGameruleSet(GameRule.DO_INSOMNIA, false, playerworld, p);
                        gui.setItem(24, Getter.doInsomnia());
                    }else {
                        booleanGameruleSet(GameRule.DO_INSOMNIA, true, playerworld, p);
                        gui.setItem(24, Getter.doInsomnia());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doImmediateRespawn")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_IMMEDIATE_RESPAWN)) {
                        booleanGameruleSet(GameRule.DO_IMMEDIATE_RESPAWN, false, playerworld, p);
                        gui.setItem(25, Getter.doImmediateRespawn());
                    } else {
                        booleanGameruleSet(GameRule.DO_IMMEDIATE_RESPAWN, true, playerworld, p);
                        gui.setItem(25, Getter.doImmediateRespawn());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "drowningDamage")) {
                    if (playerworld.getGameRuleValue(GameRule.DROWNING_DAMAGE)) {
                        booleanGameruleSet(GameRule.DROWNING_DAMAGE, false, playerworld, p);
                        gui.setItem(26, Getter.drowningDamage());
                    } else {
                        booleanGameruleSet(GameRule.DROWNING_DAMAGE, true, playerworld, p);
                        gui.setItem(26, Getter.drowningDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "fireDamage")) {
                    if (playerworld.getGameRuleValue(GameRule.FIRE_DAMAGE)) {
                        booleanGameruleSet(GameRule.FIRE_DAMAGE, false, playerworld, p);
                        gui.setItem(27, Getter.fireDamage());
                    } else {
                        booleanGameruleSet(GameRule.FIRE_DAMAGE, true, playerworld, p);
                        gui.setItem(27, Getter.fireDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "fallDamage")) {
                    if (playerworld.getGameRuleValue(GameRule.FALL_DAMAGE)) {
                        booleanGameruleSet(GameRule.FALL_DAMAGE, false, playerworld, p);
                        gui.setItem(28, Getter.fallDamage());
                    } else {
                        booleanGameruleSet(GameRule.FALL_DAMAGE, true, playerworld, p);
                        gui.setItem(28, Getter.fallDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doPatrolSpawning")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_PATROL_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_PATROL_SPAWNING, false, playerworld, p);
                        gui.setItem(29, Getter.doPatrolSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_PATROL_SPAWNING, true, playerworld, p);
                        gui.setItem(29, Getter.doPatrolSpawning());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doTraderSpawning")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_TRADER_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_TRADER_SPAWNING, false, playerworld, p);
                        gui.setItem(30, Getter.doTraderSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_TRADER_SPAWNING, true, playerworld, p);
                        gui.setItem(30, Getter.doTraderSpawning());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "universalAnger")) {
                    if (playerworld.getGameRuleValue(GameRule.UNIVERSAL_ANGER)) {
                        booleanGameruleSet(GameRule.UNIVERSAL_ANGER, false, playerworld, p);
                        gui.setItem(31, Getter.universalAnger());
                    } else {
                        booleanGameruleSet(GameRule.UNIVERSAL_ANGER, true, playerworld, p);
                        gui.setItem(31, Getter.universalAnger());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "forgiveDeadPlayers")) {
                    if (playerworld.getGameRuleValue(GameRule.FORGIVE_DEAD_PLAYERS)) {
                        booleanGameruleSet(GameRule.FORGIVE_DEAD_PLAYERS, false, playerworld, p);
                        gui.setItem(32, Getter.forgiveDeadPlayers());
                    } else {
                        booleanGameruleSet(GameRule.FORGIVE_DEAD_PLAYERS, true, playerworld, p);
                        gui.setItem(32, Getter.forgiveDeadPlayers());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "freezeDamage")) {
                    if (playerworld.getGameRuleValue(GameRule.FREEZE_DAMAGE)) {
                        booleanGameruleSet(GameRule.FREEZE_DAMAGE, false, playerworld, p);
                        gui.setItem(33, Getter.freezeDamage());
                    } else {
                        booleanGameruleSet(GameRule.FREEZE_DAMAGE, true, playerworld, p);
                        gui.setItem(33, Getter.freezeDamage());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "playersSleepingPercentage")) {
                    p.closeInventory();
                    valueReceiver(p,"playersSleepingPercentage");
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "doWardenSpawning")) {
                    if (playerworld.getGameRuleValue(GameRule.DO_WARDEN_SPAWNING)) {
                        booleanGameruleSet(GameRule.DO_WARDEN_SPAWNING, false, playerworld, p);
                        gui.setItem(35, Getter.doWardenSpawning());
                    } else {
                        booleanGameruleSet(GameRule.DO_WARDEN_SPAWNING, true, playerworld, p);
                        gui.setItem(35, Getter.doWardenSpawning());
                    }
                }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Get Back in World Selection.")) {
                        GUI.guiBuilder(p);
                }


            }
            //for 1.13 NullPointerException if you click air
        }catch (NullPointerException ex) { }
    }

    private void valueReceiver(Player p, String gamerule) {
        World w = p.getWorld();
        new AnvilGUI.Builder().onComplete((player, text) -> {
                    int value;
                    try{
                        value = Integer.parseInt(text);
                    }catch (NumberFormatException ex){
                        player.sendMessage(prefix + ChatColor.YELLOW + "You didn't type an " + ChatColor.RED + "integer number" + ChatColor.YELLOW +".");
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                        return AnvilGUI.Response.openInventory(GUI.guiBuilder(p));
                    }
                    switch (gamerule) {
                        case "randomTickSpeed":
                            w.setGameRule(GameRule.RANDOM_TICK_SPEED, value);
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            return AnvilGUI.Response.openInventory(GUI.guiBuilder(p));
                        case "spawnRadius":
                            w.setGameRule(GameRule.SPAWN_RADIUS, value);
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            return AnvilGUI.Response.openInventory(GUI.guiBuilder(p));
                        case "maxEntityCramming":
                            w.setGameRule(GameRule.MAX_ENTITY_CRAMMING, value);
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            return AnvilGUI.Response.openInventory(GUI.guiBuilder(p));
                        case "maxCommandChainLength":
                            w.setGameRule(GameRule.MAX_COMMAND_CHAIN_LENGTH, value);
                            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                            return AnvilGUI.Response.openInventory(GUI.guiBuilder(p));
                        case "playersSleepingPercentage":
                                w.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, value);
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                                return AnvilGUI.Response.openInventory(GUI.guiBuilder(p));
                        }
                    return null;
                })
                .text("Read paper's info.")
                .itemLeft(new ItemStack(getItem()))
                .title("Enter your value.")
                .plugin(GameruleManager.getPlugin())
                .open(p);
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
