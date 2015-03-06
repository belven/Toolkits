package belven.toolkits.testimplementations;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Slot;
import belven.toolkits.Toolkit;

public class CloseButton extends Slot {
	Toolkit currentToolkit;

	public CloseButton(Toolkit currentToolkit, int position, ItemStack item, String lore) {
		super(position, item, lore);
		this.currentToolkit = currentToolkit;
	}

	@Override
	public void pressed(Player p) {
		if (currentToolkit != null) {
			currentToolkit.closeToolkit();
		}
	}

}
