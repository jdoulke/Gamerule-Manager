package me.ted2001.gamerulesmanager.Gamerules;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GameruleGetter {

    Player p;

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

    public GameruleGetter(Player player){
        this.p = player;
    }

    public ItemStack announceAdvancements(){
        return AnnounceAdvancements.announceAdvancementz(p);
    }
    public ItemStack commandBlockOutput(){
        return CommandBlockOutput.commandBlockOutput(p);
    }
    public ItemStack disableElytraMovementCheck(){return DisableElytraMovementCheck.DisableElytraMovementCheck(p);}
    public ItemStack disableRaids(){
        return DisableRaids.disableRaids(p);
    }
    public ItemStack daylightCycle(){
        return DoDaylightCycle.doDaylightCycle(p);
    }
    public ItemStack doFireTick(){
        return DoFireTick.doFireTick(p);
    }
    public ItemStack entityDrops(){
        return DoEntityDrops.doEntityDrops(p);
    }
    public ItemStack doInsomnia(){
        return DoInsomnia.doInsomnia(p);
    }
    public ItemStack doImmediateRespawn(){
        return DoImmediateRespawn.doImmediateRespawn(p);
    }
    public ItemStack mobGriefing(){
        return MobGriefing.mobGriefing(p);
    }
    public ItemStack doMobSpawning(){
        return DoMobSpawning.doMobSpawning(p);
    }
    public ItemStack doMobLoot(){
        return DoMobLoot.doMobLoot(p);
    }
    public ItemStack doTileDrops(){
        return DoTileDrops.doTileDrops(p);
    }
    public ItemStack keepInventory(){
        return KeepInventory.keepInventory(p);
    }
    public ItemStack naturalRegeneration(){
        return NaturalRegeneration.naturalRegeneration(p);
    }
    public ItemStack logAdminCommands(){
        return LogAdminCommands.logAdminCommands(p);
    }
    public ItemStack showDeathMessages(){
        return ShowDeathMessages.showDeathMessages(p);
    }
    public ItemStack sendCommandFeedback(){
        return SendCommandFeedback.sendCommandFeedback(p);
    }
    public ItemStack randomTickSpeed() {return RandomTickSpeed.randomTickSpeed(p);}
    public ItemStack reducedDebugInfo() {return ReducedDebugInfo.reducedDebugInfo(p);}
    public ItemStack spectatorsGenerateChunks() {return SpectatorsGenerateChunks.spectatorsGenerateChunks(p);}
    public ItemStack spawnRadius() {return SpawnRadius.spawnRadius(p);}
    public ItemStack doWeatherCycle() {return DoWeatherCycle.doWeatherCycle(p);}
    public ItemStack maxEntityCramming() {return MaxEntityCramming.maxEntityCramming(p);}
    public ItemStack doLimitedCrafting(){return DoLimitedCrafting.doLimitedCrafting(p);}
    public ItemStack maxCommandChainLength(){return MaxCommandChainLength.maxCommandChainLength(p);}
    public ItemStack drowningDamage(){return DrowningDamage.drowningDamage(p);}
    public ItemStack fireDamage(){return FireDamage.fireDamage(p);}
    public ItemStack fallDamage(){return FallDamage.fallDamage(p);}
    public ItemStack doPatrolSpawning(){return DoPatrolSpawning.doPatrolSpawning(p);}
    public ItemStack doTraderSpawning(){return DoTraderSpawning.doTraderSpawning(p);}
    public ItemStack universalAnger(){return UniversalAnger.universalAnger(p);}
    public ItemStack forgiveDeadPlayers() {return ForgiveDeadPlayers.forgiveDeadPlayers(p);}
    public ItemStack freezeDamage(){return FreezeDamage.freezeDamage(p);}
    public ItemStack playersSleepingPercentage(){return PlayersSleepingPercentage.playersSleepingPercentage(p);}

    public ItemStack doWardenSpawning(){return DoWardenSpawning.doWardenSpawning(p);}
}
