package belven.toolkits.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Toolkit;
import belven.toolkits.ToolkitManager;

public class PlayerListener implements Listener {
	ToolkitManager plugin;
	boolean given = true;

	public PlayerListener(ToolkitManager instance) {
		plugin = instance;
	}

	@EventHandler
	public void onPlayerLoginEvent(PlayerLoginEvent event) {
		given = !given;
		// plugin.CreateTestToolkit(event.getPlayer());
	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {

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
	public void onInventoryClickEvent(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();

		if (!given) {
			plugin.CreateTestToolkit(p);
			given = !given;
		}

		if (!event.isCancelled() && isItemAButton(event.getSlot(), p) && HandleButtonPress(p, event.getSlot())) {
			event.setCancelled(true);
		}
	}

	private boolean isItemAButton(int pos, Player p) {
		return plugin.getToolkit(p).contains(pos) ? true : false;
	}

	public boolean HandleButtonPress(Player p, int pos) {

		if (p == null) {
			return false;
		}

		plugin.getToolkit(p).getSlot(pos).pressed(p);

		return true;
	}

	/* public boolean HandleButtonPress(Player p, ItemStack is) {
	 * 
	 * if (p == null) { return false; }
	 * 
	 * // Bukkit.getServer().getLogger().info(getDisplayName(is));
	 * 
	 * if (isItemAButton(is)) {
	 * 
	 * // Bukkit.getServer().getLogger().info(getItemLore(is));
	 * 
	 * if (plugin.getToolkit(p).contains(getItemLore(is))) {
	 * 
	 * plugin.getToolkit(p).getSlot(getItemLore(is)).pressed(p); // Bukkit.getServer().getLogger().info("Button pressed"); }
	 * 
	 * return true; }
	 * 
	 * return false; } */

	/* private boolean isItemAButton(ItemStack is) { return is != null && is.getItemMeta() != null && getDisplayName(is).equals("Button"); } */

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