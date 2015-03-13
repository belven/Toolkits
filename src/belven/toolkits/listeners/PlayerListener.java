package belven.toolkits.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Slot;
import belven.toolkits.Toolkit;
import belven.toolkits.ToolkitManager;
import belven.toolkits.buttons.OpenButton;

public class PlayerListener implements Listener {
	ToolkitManager plugin;
	boolean given = false;

	public PlayerListener(ToolkitManager instance) {
		plugin = instance;
	}

	@EventHandler
	public void onPlayerLoginEvent(PlayerLoginEvent event) {
		// plugin.CreateTestToolkit(event.getPlayer());
	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		given = false;

		Toolkit t = plugin.getToolkit(event.getPlayer());

		if (t != null) {
			t.close();
		}
	}

	public String getItemLore(ItemStack is) {
		if (is.getItemMeta().getLore().size() > 0) {
			return is.getItemMeta().getLore().get(0);
		}

		return "Lore not found";
	}

	public String getDisplayName(ItemStack is) {
		return is != null ? is.getItemMeta() != null ? is.getItemMeta().getDisplayName() != null ? is.getItemMeta()
				.getDisplayName() : "" : "" : "";
	}

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		Player p = event.getPlayer();

		if (!event.isCancelled() && isItemAButton(p.getInventory().getHeldItemSlot(), p)
				&& HandleButtonPress(p, p.getInventory().getHeldItemSlot())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		Player p = event.getPlayer();

		if (!event.isCancelled() && isItemAButton(p.getInventory().getHeldItemSlot(), p)
				&& HandleButtonPress(p, p.getInventory().getHeldItemSlot())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();

		if (!given) {
			plugin.CreateTestToolkit(p);
			given = true;
		}

		if (!event.isCancelled() && isItemAButton(event.getSlot(), p) && HandleButtonPress(p, event.getSlot())) {
			event.setCancelled(true);
		}
	}

	private boolean isItemAButton(int pos, Player p) {
		return plugin.getToolkit(p) != null ? plugin.getToolkit(p).contains(pos) ? true : false : false;
	}

	public boolean HandleButtonPress(Player p, int pos) {
		if (p == null) {
			return false;
		}

		Slot s = plugin.getToolkit(p).getSlot(pos);

		if (s instanceof OpenButton || plugin.getToolkit(p).isOpen()) {
			s.pressed(p);
		}

		return true;
	}

	// @EventHandler
	// public void onInventoryDragEvent(InventoryDragEvent event) {
	// Player p = (Player) event.getWhoClicked();
	// Bukkit.getServer().getLogger().info("Dragged");
	//
	// if (isItemAButton(event.getInventorySlots().iterator().next(), p)) {
	// event.setCancelled(true);
	// }
	// }
	//
	// @EventHandler
	// public void onInventoryMoveItemEvent(InventoryMoveItemEvent event) {
	// ItemStack is = event.getItem();
	// Bukkit.getServer().getLogger().info("Moved");
	//
	// if (isItemAButton(is)) {
	// event.setCancelled(true);
	// }
	// }

}