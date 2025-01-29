package com.artillexstudios.axboostersexamplehook;

import org.bukkit.plugin.java.JavaPlugin;

public final class AxBoostersExampleHook extends JavaPlugin {

    @Override
    public void onEnable() {
        // don't forget to register our listener
        // it is important to register is as soon as possible
        AxBoostersLoadListener loadListener = new AxBoostersLoadListener(this);
        this.getServer().getPluginManager().registerEvents(loadListener, this);
    }
}
