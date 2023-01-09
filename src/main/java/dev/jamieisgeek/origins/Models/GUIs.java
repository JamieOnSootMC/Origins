package dev.jamieisgeek.origins.Models;

import dev.jamieisgeek.origins.Manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIs {
    private final String GUIType;

    public GUIs(String menuType, Player toShow) {
        this.GUIType = menuType;

        switch(GUIType) {
            case "initSelect":
                this.initialSelection(toShow);
                break;
            case "swapSelection":
                this.swapSelection(toShow);
                break;
        }
    }

    private void initialSelection(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 45, ChatColor.GOLD + "Select your Origin");

        ItemStack filler = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(" ");
        filler.setItemMeta(fillerMeta);

        ItemStack avien = new ItemStack(Material.FEATHER);
        ItemMeta avienMeta = avien.getItemMeta();
        avienMeta.setDisplayName(ChatColor.GOLD + "Avien");
        avien.setItemMeta(avienMeta);

        ItemStack human = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta humanMeta = human.getItemMeta();
        humanMeta.setDisplayName(ChatColor.GOLD + "Human");
        human.setItemMeta(humanMeta);

        ItemStack enderian = new ItemStack(Material.ENDER_PEARL);
        ItemMeta enderianMeta = enderian.getItemMeta();
        enderianMeta.setDisplayName(ChatColor.GOLD + "Enderian");
        enderian.setItemMeta(enderianMeta);

        ItemStack merling = new ItemStack(Material.COD);
        ItemMeta merlingMeta = merling.getItemMeta();
        merlingMeta.setDisplayName(ChatColor.GOLD + "Merling");
        merling.setItemMeta(merlingMeta);

        ItemStack phantom = new ItemStack(Material.PHANTOM_MEMBRANE);
        ItemMeta phantomMeta = phantom.getItemMeta();
        phantomMeta.setDisplayName(ChatColor.GOLD + "Phantom");
        phantom.setItemMeta(phantomMeta);

        ItemStack elytrian = new ItemStack(Material.ELYTRA);
        ItemMeta elytrianMeta = elytrian.getItemMeta();
        elytrianMeta.setDisplayName(ChatColor.GOLD + "Elytrian");
        elytrian.setItemMeta(elytrianMeta);

        ItemStack blazeborn = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta blazebornMeta = blazeborn.getItemMeta();
        blazebornMeta.setDisplayName(ChatColor.GOLD + "Blazeborn");
        blazeborn.setItemMeta(blazebornMeta);

        ItemStack arachnid = new ItemStack(Material.SPIDER_EYE);
        ItemMeta arachnidMeta = arachnid.getItemMeta();
        arachnidMeta.setDisplayName(ChatColor.GOLD + "Arachnid");
        arachnid.setItemMeta(arachnidMeta);

        ItemStack shulk = new ItemStack(Material.SHULKER_SHELL);
        ItemMeta shulkMeta = shulk.getItemMeta();
        shulkMeta.setDisplayName(ChatColor.GOLD + "Shulk");
        shulk.setItemMeta(shulkMeta);

        ItemStack feline =  new ItemStack(Material.ORANGE_WOOL);
        ItemMeta felineMeta = feline.getItemMeta();
        felineMeta.setDisplayName(ChatColor.GOLD + "Feline");
        feline.setItemMeta(felineMeta);

        for (int i = 0; i < 9; i++) {
            inventory.setItem(i, filler);
        }
        for (int i = 36; i < 45; i++) {
            inventory.setItem(i, filler);
        }
        for (int i = 9; i < 36; i += 9) {
            inventory.setItem(i, filler);
        }
        for (int i = 17; i < 36; i += 9) {
            inventory.setItem(i, filler);
        }

        inventory.setItem(10, avien);
        inventory.setItem(12, human);
        inventory.setItem(14, enderian);
        inventory.setItem(16, merling);
        inventory.setItem(20, phantom);
        inventory.setItem(24, elytrian);
        inventory.setItem(28, blazeborn);
        inventory.setItem(30, arachnid);
        inventory.setItem(32, shulk);
        inventory.setItem(34, feline);

        player.openInventory(inventory);
        Manager.getManager().addPlayerInventory(player, inventory);
    }

    private void swapSelection(Player player) {

    }
}
