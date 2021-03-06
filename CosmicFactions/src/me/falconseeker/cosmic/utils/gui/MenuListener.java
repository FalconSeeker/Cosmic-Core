package me.falconseeker.cosmic.utils.gui;

import me.falconseeker.cosmic.utils.gui.button.ButtonOptions;
import me.falconseeker.cosmic.utils.gui.button.IMenuButton;
import me.falconseeker.cosmic.utils.gui.events.ButtonClickEvent;
import me.falconseeker.cosmic.utils.gui.events.ClickType;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;

public class MenuListener implements Listener {

	private static boolean initialized;

	private MenuListener(JavaPlugin plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
		initialized = true;
	}

	private MenuListener() {};

	public static void register(JavaPlugin plugin) {

		if (!initialized)
			new me.falconseeker.cosmic.utils.gui.MenuListener(plugin);

	}

	@EventHandler
	public void listenClick(InventoryClickEvent event) {

		Inventory inventory = event.getClickedInventory();

		if (inventory == null)
			return;

		InventoryHolder holder = inventory.getHolder();

		if (!(holder instanceof IMenu))
			return;

		final ItemStack clickedItem = event.getCurrentItem();

		if (clickedItem == null || clickedItem.getType() == Material.AIR)
			return;

		IMenu menu = (IMenu) holder;
		IMenuButton clickedButton = menu.findButtonByItem(clickedItem);

		if (clickedButton != null) {

			if (clickedButton.containsData(ButtonOptions.CANCEL_EVENT.getIdentifier())) {

				if (((boolean) clickedButton.getItemData().get(ButtonOptions.CANCEL_EVENT.getIdentifier()))) {
					event.setCancelled(true);
				}

			} else
				event.setCancelled(true);

			ClickType clickType;
			if (event.isShiftClick()) {
				if (event.isLeftClick())
					clickType = ClickType.SHIFT_LEFT;
				else
					clickType = ClickType.SHIFT_RIGHT;
			} else {
				if (event.isLeftClick())
					clickType = ClickType.LEFT;
				else
					clickType = ClickType.RIGHT;
			}

			ButtonClickEvent buttonClickEvent = new ButtonClickEvent(clickedButton, ((Player) event.getWhoClicked()),
					event.getClickedInventory(), event.getSlot(), clickType);

			if (clickedButton.getClickEvent() != null) {
				clickedButton.getClickEvent().accept(buttonClickEvent);
			} else if (menu.getClickListener() != null)
			menu.getClickListener().accept(buttonClickEvent);

		} else {

			if(menu.getItemClickEvent() != null) menu.getItemClickEvent().accept(event);

		}
	}

	@EventHandler
	public void onClose(InventoryCloseEvent event) {

		InventoryHolder holder = event.getInventory().getHolder();

		if (!(holder instanceof IMenu))
			return;

		IMenu menu = (IMenu) holder;

		Consumer<InventoryCloseEvent> closeListener = menu.getCloseListener();

		if (closeListener != null)
			closeListener.accept(event);

	}

	@EventHandler
	public void onOpen(InventoryOpenEvent event) {

		InventoryHolder holder = event.getInventory().getHolder();

		if (!(holder instanceof IMenu))
			return;

		IMenu menu = (IMenu) holder;

		Consumer<InventoryOpenEvent> openListener = menu.getOpenListener();

		if (openListener != null)
			openListener.accept(event);

	}

	@EventHandler
    public void onPickup(InventoryPickupItemEvent event){

        InventoryHolder holder = event.getInventory().getHolder();

        if (!(holder instanceof IMenu))
            return;

        IMenu menu = (IMenu) holder;

        Consumer<InventoryPickupItemEvent> pickupListener = menu.getPickupListener();
        if(pickupListener != null){
            pickupListener.accept(event);
        }
    }
}
