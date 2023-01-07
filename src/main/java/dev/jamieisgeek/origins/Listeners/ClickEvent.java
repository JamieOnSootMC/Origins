package dev.jamieisgeek.origins.Listeners;

import dev.jamieisgeek.origins.Manager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) {
            return;
        }

        if (event.getClickedInventory().getHolder() == null) {
            return;
        }

        if (!Manager.getManager().getSelectingPlayers().contains((Player) event.getWhoClicked())) {
            return;
        }

        if (event.getView().getTitle().equals(ChatColor.GOLD + "Select your Origin")) {
            event.setCancelled(true);

            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) {
                return;
            }


            switch (event.getCurrentItem().getType()) {
                case FEATHER:
                    break;
                case PLAYER_HEAD:
                    break;
                case ENDER_PEARL:
                    break;
                case COD:
                    break;
                case PHANTOM_MEMBRANE:
                    break;
                case ELYTRA:
                    break;
                case BLAZE_POWDER:
                    break;
                case SPIDER_EYE:
                    break;
                case SHULKER_SHELL:
                    break;
                case ORANGE_WOOL:
                    break;
                default:
                    break;
            }
        }
    }
}
