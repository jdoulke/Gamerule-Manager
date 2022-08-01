package me.ted2001.gamerulesmanager;


public class CopyGamerules {

    String gameRule;
    String value;

    public String getGameRule() {
        return gameRule;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CopyGamerules(String gameRule, String value) {
        this.gameRule = gameRule;
        this.value = value;
    }
}
