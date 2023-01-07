package dev.jamieisgeek.origins.Listeners;

import dev.jamieisgeek.origins.Manager;
import dev.jamieisgeek.origins.Models.GUIs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPlayedBefore()) {
            return;
        }

        Manager.getManager().setPlayerSelecting(event.getPlayer(), "initSelect");
    }
}
