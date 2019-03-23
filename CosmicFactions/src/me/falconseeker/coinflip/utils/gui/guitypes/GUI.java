package me.falconseeker.coinflip.utils.gui.guitypes;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import me.falconseeker.coinflip.utils.gui.IMenu;

public class GUI extends IMenu {

    private GUI(int rows, String title){
        setTitle(title);
        setInventorySize(rows);
    }
    public static GUI create(int rows, String title){
        return new GUI(rows,title);
    }

    @Override
    public Inventory build() {

        Inventory inv = Bukkit.createInventory(this, getSize(),getTitle());
        setDummies(inv);
        setInventory(inv);
        return inv;

    }
}
