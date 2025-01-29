package com.artillexstudios.axboostersexamplehook;

import com.artillexstudios.axboosters.boosters.BoosterManager;
import com.artillexstudios.axboosters.hooks.booster.BoosterHook;
import com.artillexstudios.axboosters.libs.kyori.adventure.key.Key;
import com.artillexstudios.axboosters.users.User;
import com.artillexstudios.axboosters.users.UserList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.jetbrains.annotations.NotNull;

public class VanillaExpHook implements Listener, BoosterHook {

    @Override
    public Key getKey() {
        return Key.key("myplugin", "example_experience");
    }

    @Override
    public Material getIcon() {
        return Material.EXPERIENCE_BOTTLE;
    }

    @Override
    public boolean isPersistent() {
        return true;
    }

    @EventHandler
    public void onEvent(@NotNull PlayerExpChangeEvent event) {
        int original = event.getAmount();
        Player player = event.getPlayer();

        User user = UserList.getUser(player);
        if (user == null) {
            return;
        }

        float boost = user.getBoost(this);
        if (boost == 1.0f) {
            return;
        }

        int boosted = BoosterManager.multiply(boost, original);
        if (boosted == original) return;

        event.setAmount(boosted);
    }
}
