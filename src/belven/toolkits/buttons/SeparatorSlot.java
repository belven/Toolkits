package belven.toolkits.buttons;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Slot;

public class SeparatorSlot extends Slot {

	public SeparatorSlot(int position, ItemStack item) {
		super(position, item, "Separator");
	}

	@Override
	public void pressed(Player p) {

	}

}
