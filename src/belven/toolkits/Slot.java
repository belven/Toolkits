package belven.toolkits;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import belven.toolkits.testimplementations.CloseButton;
import belven.toolkits.testimplementations.OpenButton;

public abstract class Slot {
	private int position = 0;
	private ItemStack item;
	private String lore = "";

	public Slot(int position, ItemStack item, String lore) {
		this.setPosition(position);
		this.setItem(item);
		this.setLore(lore);

		SetItemLore(lore, item);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName("Button");
		item.setItemMeta(itemMeta);
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

	public Slot closeButton(int pos, ItemStack item, Toolkit e) {
		return new CloseButton(e, pos, item, "");
	}

	public Slot openButton(int pos, ItemStack item, Toolkit e) {
		return new OpenButton(e, pos, item, "");
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

	public String getLore() {
		return lore;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}

}
