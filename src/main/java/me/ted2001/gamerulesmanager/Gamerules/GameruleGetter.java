package me.ted2001.gamerulesmanager.Gamerules;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GameruleGetter {

    World w;

    AnnounceAdvancements AnnounceAdvancements = new AnnounceAdvancements();
    CommandBlockOutput CommandBlockOutput = new CommandBlockOutput();
    DisableElytraMovementCheck DisableElytraMovementCheck = new DisableElytraMovementCheck();
    DisableRaids DisableRaids = new DisableRaids();
    DoDaylightCycle DoDaylightCycle = new DoDaylightCycle();
    DoEntityDrops DoEntityDrops = new DoEntityDrops();
    DoFireTick DoFireTick = new DoFireTick();
    DoInsomnia DoInsomnia = new DoInsomnia();
    DoImmediateRespawn DoImmediateRespawn = new DoImmediateRespawn();
    MobGriefing MobGriefing = new MobGriefing();
    DoMobSpawning DoMobSpawning = new DoMobSpawning();
    DoMobLoot DoMobLoot = new DoMobLoot();
    DoTileDrops DoTileDrops = new DoTileDrops();
    KeepInventory KeepInventory = new KeepInventory();
    NaturalRegeneration NaturalRegeneration = new NaturalRegeneration();
    LogAdminCommands LogAdminCommands = new LogAdminCommands();
    ShowDeathMessages ShowDeathMessages = new ShowDeathMessages();
    SendCommandFeedback SendCommandFeedback = new SendCommandFeedback();
    RandomTickSpeed RandomTickSpeed = new RandomTickSpeed();
    ReducedDebugInfo ReducedDebugInfo = new ReducedDebugInfo();
    SpectatorsGenerateChunks SpectatorsGenerateChunks = new SpectatorsGenerateChunks();
    SpawnRadius SpawnRadius = new SpawnRadius();
    DoWeatherCycle DoWeatherCycle = new DoWeatherCycle();
    MaxEntityCramming MaxEntityCramming = new MaxEntityCramming();
    DoLimitedCrafting DoLimitedCrafting = new DoLimitedCrafting();
    MaxCommandChainLength MaxCommandChainLength = new MaxCommandChainLength();
    DrowningDamage DrowningDamage = new DrowningDamage();
    FireDamage FireDamage = new FireDamage();
    FallDamage FallDamage = new FallDamage();
    DoPatrolSpawning DoPatrolSpawning = new DoPatrolSpawning();
    DoTraderSpawning DoTraderSpawning = new DoTraderSpawning();
    UniversalAnger UniversalAnger = new UniversalAnger();
    ForgiveDeadPlayers ForgiveDeadPlayers = new ForgiveDeadPlayers();
    FreezeDamage  FreezeDamage = new FreezeDamage();
    PlayersSleepingPercentage PlayersSleepingPercentage = new PlayersSleepingPercentage();
    DoWardenSpawning DoWardenSpawning = new DoWardenSpawning();

    public GameruleGetter(World w){this.w = w;}

    public ItemStack announceAdvancements(){
        return AnnounceAdvancements.announceAdvancementz(w);
    }
    public ItemStack commandBlockOutput(){
        return CommandBlockOutput.commandBlockOutput(w);
    }
    public ItemStack disableElytraMovementCheck(){return DisableElytraMovementCheck.DisableElytraMovementCheck(w);}
    public ItemStack disableRaids(){
        return DisableRaids.disableRaids(w);
    }
    public ItemStack daylightCycle(){
        return DoDaylightCycle.doDaylightCycle(w);
    }
    public ItemStack doFireTick(){return DoFireTick.doFireTick(w);}
    public ItemStack entityDrops(){
        return DoEntityDrops.doEntityDrops(w);
    }
    public ItemStack doInsomnia(){
        return DoInsomnia.doInsomnia(w);
    }
    public ItemStack doImmediateRespawn(){
        return DoImmediateRespawn.doImmediateRespawn(w);
    }
    public ItemStack mobGriefing(){
        return MobGriefing.mobGriefing(w);
    }
    public ItemStack doMobSpawning(){
        return DoMobSpawning.doMobSpawning(w);
    }
    public ItemStack doMobLoot(){
        return DoMobLoot.doMobLoot(w);
    }
    public ItemStack doTileDrops(){
        return DoTileDrops.doTileDrops(w);
    }
    public ItemStack keepInventory(){
        return KeepInventory.keepInventory(w);
    }
    public ItemStack naturalRegeneration(){
        return NaturalRegeneration.naturalRegeneration(w);
    }
    public ItemStack logAdminCommands(){
        return LogAdminCommands.logAdminCommands(w);
    }
    public ItemStack showDeathMessages(){
        return ShowDeathMessages.showDeathMessages(w);
    }
    public ItemStack sendCommandFeedback(){
        return SendCommandFeedback.sendCommandFeedback(w);
    }
    public ItemStack randomTickSpeed() {return RandomTickSpeed.randomTickSpeed(w);}
    public ItemStack reducedDebugInfo() {return ReducedDebugInfo.reducedDebugInfo(w);}
    public ItemStack spectatorsGenerateChunks() {return SpectatorsGenerateChunks.spectatorsGenerateChunks(w);}
    public ItemStack spawnRadius() {return SpawnRadius.spawnRadius(w);}
    public ItemStack doWeatherCycle() {return DoWeatherCycle.doWeatherCycle(w);}
    public ItemStack maxEntityCramming() {return MaxEntityCramming.maxEntityCramming(w);}
    public ItemStack doLimitedCrafting(){return DoLimitedCrafting.doLimitedCrafting(w);}
    public ItemStack maxCommandChainLength(){return MaxCommandChainLength.maxCommandChainLength(w);}
    public ItemStack drowningDamage(){return DrowningDamage.drowningDamage(w);}
    public ItemStack fireDamage(){return FireDamage.fireDamage(w);}
    public ItemStack fallDamage(){return FallDamage.fallDamage(w);}
    public ItemStack doPatrolSpawning(){return DoPatrolSpawning.doPatrolSpawning(w);}
    public ItemStack doTraderSpawning(){return DoTraderSpawning.doTraderSpawning(w);}
    public ItemStack universalAnger(){return UniversalAnger.universalAnger(w);}
    public ItemStack forgiveDeadPlayers() {return ForgiveDeadPlayers.forgiveDeadPlayers(w);}
    public ItemStack freezeDamage(){return FreezeDamage.freezeDamage(w);}
    public ItemStack playersSleepingPercentage(){return PlayersSleepingPercentage.playersSleepingPercentage(w);}

    public ItemStack doWardenSpawning(){return DoWardenSpawning.doWardenSpawning(w);}
}
