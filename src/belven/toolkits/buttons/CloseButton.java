package belven.toolkits.buttons;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Closeable;
import belven.toolkits.Slot;

public class CloseButton extends Slot {
	Closeable objectToClose;

	public CloseButton(Closeable objectToClose, int position, ItemStack item, String lore) {
		super(position, item, lore);
		this.objectToClose = objectToClose;
	}

	@Override
	public void pressed(Player p) {
		if (objectToClose != null) {
			objectToClose.close();
		}
	}

}
