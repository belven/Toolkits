package belven.toolkits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.buttons.NextPage;
import belven.toolkits.buttons.PreviousPage;

public abstract class Page extends SlotContainer {
	private Toolkit toolkit;

	public Toolkit getToolkit() {
		return toolkit;
	}

	public void setToolkit(Toolkit toolkit) {
		this.toolkit = toolkit;
	}

	public Page(Toolkit owner, List<Slot> slots) {
		super(slots, Arrays.asList(9, 35));
		this.toolkit = owner;

		addSlot(new PreviousPage(owner.getMenu(), 34, new ItemStack(Material.SIGN), "Previous Page"));
		addSlot(new NextPage(owner.getMenu(), 35, new ItemStack(Material.SIGN), "Next Page"));
	}

	public Page(Toolkit owner) {
		this(owner, new ArrayList<Slot>());
	}

	@Override
	public void open() {
		for (Slot s : getSlots()) {
			getToolkit().getPlayerInventory().setItem(s.getPosition(), s.getItem());
		}
		setOpen(true);
	}

	@Override
	public void close() {
		for (Slot s : getSlots()) {
			getToolkit().getPlayerInventory().setItem(s.getPosition(), new ItemStack(Material.AIR));
		}
		setOpen(false);
	}
}
