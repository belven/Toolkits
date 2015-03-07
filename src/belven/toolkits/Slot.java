package belven.toolkits;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

	public abstract void pressed(Player p);

	public void remove() {

	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public ItemStack getItem() {
		return item;
	}

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
