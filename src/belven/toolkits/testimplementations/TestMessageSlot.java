package belven.toolkits.testimplementations;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Slot;

public class TestMessageSlot extends Slot {

	public TestMessageSlot(int position, ItemStack item, String lore) {
		super(position, item, lore);
	}

	@Override
	public void pressed(Player p) {
		p.sendMessage("You pressed the button " + getName());
		// Bukkit.getServer().getLogger().info("OB pressed");
	}

}
