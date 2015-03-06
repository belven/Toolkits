package belven.toolkits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class Toolbar extends SlotContainer {
	public Toolkit toolkit;

	public Toolkit getToolkit() {
		return toolkit;
	}

	public void setToolkit(Toolkit toolkit) {
		this.toolkit = toolkit;
	}

	public Toolbar(Toolkit toolkit) {
		this(toolkit, new ArrayList<Slot>());
	}

	public Toolbar(Toolkit toolkit, List<Slot> slots) {
		super(slots, Arrays.asList(0, 8));
		this.toolkit = toolkit;
		toolkit.setToolbar(this);
	}

	public void openToolbar() {
		for (Slot s : getSlots()) {
			getToolkit().getPlayerInventory().setItem(s.getPosition(), s.getItem());
		}
	}

	public void closeToolbar() {
		for (Slot s : getSlots()) {
			getToolkit().getPlayerInventory().setItem(s.getPosition(), new ItemStack(Material.AIR));
		}

	}
}