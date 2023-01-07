package dev.jamieisgeek.origins.Commands;

import dev.jamieisgeek.CommandHandler;
import dev.jamieisgeek.CommandInfo;
import dev.jamieisgeek.origins.Manager;
import org.bukkit.entity.Player;

@CommandInfo(name = "test", requiresPlayer = true)
public class TestCommand extends CommandHandler {
    @Override
    public void execute(Player player, String[] args) {
        Manager.getManager().setPlayerSelecting(player, "initSelect");
        player.sendMessage("opening gui");
    }
}
