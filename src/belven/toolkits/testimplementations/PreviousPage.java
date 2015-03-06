package belven.toolkits.testimplementations;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Menu;
import belven.toolkits.Slot;

public class PreviousPage extends Slot {
	public Menu m;

	public PreviousPage(Menu m, int position, ItemStack item, String lore) {
		super(position, item, lore);
		this.m = m;
	}

	@Override
	public void pressed(Player p) {
		int index = m.getCurrentIndex() - 1;
		m.openPage(index);
		p.sendMessage("Going to page " + String.valueOf(m.getCurrentIndex() + 1));
	}

}
