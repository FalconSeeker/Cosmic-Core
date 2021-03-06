package me.falconseeker.cosmic.utils.gui.events;

import me.falconseeker.cosmic.utils.gui.IMenu;
import me.falconseeker.cosmic.utils.gui.button.IMenuButton;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ButtonClickEvent {

    public IMenuButton getClickedButton() {
        return clickedButton;
    }

    private IMenuButton clickedButton;
    private Player whoClicked;
    private IMenu clickedMenu;
    private int slot;
    private ClickType clickType;
    private Inventory clickedInventory;

    public ButtonClickEvent(IMenuButton clickedButton, Player whoClicked, Inventory clickedInventory, int slot, ClickType clickType) {

        this.clickedButton = clickedButton;
        this.whoClicked = whoClicked;
        this.slot = slot;
        this.clickType = clickType;
        this.clickedMenu = ((IMenu) clickedInventory.getHolder());
        this.clickedInventory = clickedInventory;

    }

    public IMenu getClickedMenu() {
        return clickedMenu;
    }

    public Player getWhoClicked() {
        return whoClicked;
    }

    public int getSlot() {
        return slot;
    }

    public Inventory getClickedInventory() {
        return clickedInventory;
    }

    public ClickType getClickType() {
        return clickType;
    }
}
