package com.artillexstudios.axboostersexamplehook;

import com.artillexstudios.axboosters.api.AxBoostersAPI;
import com.artillexstudios.axboosters.api.events.AxBoostersLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class AxBoostersLoadListener implements Listener {
    private final JavaPlugin instance;

    public AxBoostersLoadListener(JavaPlugin instance) {
        this.instance = instance;
    }

    @EventHandler // listen to the AxBoostersLoadEvent - this is called 20 ticks after the onEnable is called in AxBoosters
    public void onLoad(AxBoostersLoadEvent event) {
        // create an instance of our booster
        VanillaExpHook vanillaExpHook = new VanillaExpHook();
        // make sure to register listener (if you are using one)
        instance.getServer().getPluginManager().registerEvents(vanillaExpHook, instance);
        // and lastly, register the booster in axboosters as well
        AxBoostersAPI.registerBoosterHook(instance, vanillaExpHook);
    }
}
