package dev.jamieisgeek.origins;

import dev.jamieisgeek.origins.Models.GUIs;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static Manager manager = null;
    private List<Player> selectingPlayers = new ArrayList<>();

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
}
