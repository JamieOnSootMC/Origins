package dev.jamieisgeek.origins.Listeners;

import dev.jamieisgeek.origins.Manager;
import dev.jamieisgeek.origins.Models.Database;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import javax.xml.crypto.Data;

public class CloseEvent implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getView().getTitle().equals(ChatColor.GOLD + "Select your Origin") && !Database.getDatabase().checkPlayerOrigin((Player) event.getPlayer())) {
            Manager.getManager().setPlayerSelecting((Player) event.getPlayer(), "initSelect");
        }
    }
}
