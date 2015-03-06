package belven.toolkits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import belven.toolkits.testimplementations.CloseButton;
import belven.toolkits.testimplementations.OpenButton;

public abstract class Toolkit {
	private Menu currentMenu;
	private Toolbar currentToolbar;
	private String name = "";
	private PlayerInventory playerInventory;
	private PlayerInventory oldPlayerInventory;
	private OpenButton ob;
	private CloseButton cb;

	public OpenButton getOpenButton() {
		return ob;
	}

	public void setOpenButton(OpenButton ob) {
		this.ob = ob;
	}

	public CloseButton getCloseButton() {
		return cb;
	}

	public void setCloseButton(CloseButton cb) {
		this.cb = cb;
	}

	@SuppressWarnings("deprecation")
	public Toolkit(ToolkitManager tm, Player player, String name) {
		this.playerInventory = player.getInventory();
		this.name = name;

		SetInventory(oldPlayerInventory, playerInventory);
		tm.getToolkits().put(player, this);

		ob = new OpenButton(this, 0, new ItemStack(Material.STONE), "Open " + name);
		cb = new CloseButton(this, 8, new ItemStack(Material.OBSIDIAN), "Close " + name);

		player.getInventory().addItem(ob.getItem());
		player.updateInventory();
	}

	public Toolbar getToolbar() {
		return currentToolbar;
	}

	public List<Slot> getSlots() {
		List<Slot> slots = new ArrayList<>();
		slots.add(ob);
		slots.add(cb);
		slots.addAll(getMenu().getSlots());
		slots.addAll(getToolbar().getSlots());
		return slots;
	}

	public void setToolbar(Toolbar currentToolbar) {
		this.currentToolbar = currentToolbar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}

	public PlayerInventory getOldPlayerInventory() {
		return oldPlayerInventory;
	}

	public void setOldPlayerInventory(PlayerInventory oldPlayerInventory) {
		this.oldPlayerInventory = oldPlayerInventory;
	}

	public abstract void openToolkit();

	public abstract void closeToolkit();

	/**
	 * Places items from one inventory into another
	 * 
	 * @param Invetory to give items
	 * @param Invetory to get items
	 */
	public void SetInventory(Inventory inv1, Inventory inv2) {
		if (inv1 == null || inv2 == null) {
			return;
		}

		for (int i = 0; i < inv2.getSize(); i++) {
			inv1.setItem(i, inv2.getItem(i));
		}
	}

	public Slot getSlot(String lore) {
		for (Slot s : getSlots()) {
			if (s.getLore().equals(lore)) {
				return s;
			}
		}

		return null;
	}

	public Slot getSlot(int pos) {
		for (Slot s : getSlots()) {
			if (s.getPosition() == pos) {
				return s;
			}
		}
		return null;
	}

	public Slot getSlot(ItemStack is) {
		for (Slot s : getSlots()) {
			if (s.getItem() == is) {
				return s;
			}
		}
		return null;
	}

	public boolean contains(String lore) {
		for (Slot s : getSlots()) {
			if (s.getLore().equals(lore)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int pos) {
		for (Slot s : getSlots()) {
			if (s.getPosition() == pos) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(ItemStack is) {
		for (Slot s : getSlots()) {
			if (s.getItem() == is) {
				return true;
			}
		}
		return false;
	}

	public Menu getMenu() {
		return currentMenu;
	}

	public void setMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

}
