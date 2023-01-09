package dev.jamieisgeek.origins;

import dev.jamieisgeek.origins.Models.GUIs;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    private static Manager manager = null;
    private List<Player> selectingPlayers = new ArrayList<>();
    private Map<Player, Inventory> playerInventories = new HashMap<>();

    public Manager() {
        manager = this;
    }

    public static Manager getManager() {
        return manager;
    }

    public ArrayList<Player> getSelectingPlayers() {
        return (ArrayList<Player>) selectingPlayers;
    }

    public void setPlayerSelecting(Player player, String type) {
        if(!selectingPlayers.contains(player)) {
            selectingPlayers.add(player);
        }

        new GUIs(type, player);
    }

    public void addPlayerInventory(Player player, Inventory inv) {
        playerInventories.put(player, inv);
    }

    public void removePlayerInventory(Player player, Inventory inv) {
        playerInventories.remove(player, inv);
    }

    public Map<Player, Inventory> getPlayerInventories() {
        return this.playerInventories;
    }
}
