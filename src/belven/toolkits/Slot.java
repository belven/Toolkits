package belven.toolkits;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A class designed to be used in a players inventory that functions like a button
 * 
 * @author sam
 * 
 */
public abstract class Slot {
	private int position = 0;
	private ItemStack item;
	private String name = "";

	public Slot(int position, ItemStack item, String name) {
		this.setPosition(position);
		this.setItem(item);
		this.setName(name);

		SetItemLore(name, item);
		// ItemMeta itemMeta = item.getItemMeta();
		// itemMeta.setDisplayName("Button");
		// item.setItemMeta(itemMeta);
		// Bukkit.getServer().getLogger().info("Slot Created");
	}

	public static void SetItemLore(String lore, ItemStack is) {
		ArrayList<String> l = new ArrayList<>();
		l.add(lore);
		ItemMeta itemMeta = is.getItemMeta();
		itemMeta.setLore(l);
		is.setItemMeta(itemMeta);
	}

	/**
	 * Used within {link PlayerListener} when the player clicks an item and therefore, does whatever the implementation does
	 * 
	 * @param p The player that pressed the button
	 */
	public abstract void pressed(Player p);

	public void remove() {

	}

	/**
	 * The position of the slot in the players inventory
	 * 
	 * @return The position of the slot
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets the position of the slot Note: doesn't physically move the slot in the players inventory
	 * 
	 * @param position The new positon of the slot
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Returns the {@link ItemStack} that is representing this slot
	 * 
	 * @return The {@link ItemStack} used by this slot
	 */
	public ItemStack getItem() {
		return item;
	}

	/**
	 * Sets the {@link ItemStack} that will represent this slot
	 * 
	 * @param item The new {@link ItemStack} the slot should use
	 */
	public void setItem(ItemStack item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
