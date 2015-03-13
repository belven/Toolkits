package belven.toolkits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.buttons.NextPage;
import belven.toolkits.buttons.PreviousPage;
import belven.toolkits.buttons.SeparatorSlot;

public abstract class Page extends SlotContainer {
	private Toolkit toolkit;

	private List<List<Integer>> vaildColumns = Arrays.asList(Arrays.asList(9, 18, 27), Arrays.asList(10, 19, 28),
			Arrays.asList(11, 20, 29), Arrays.asList(12, 21, 30), Arrays.asList(13, 22, 31), Arrays.asList(14, 23, 32),
			Arrays.asList(15, 24, 33), Arrays.asList(16, 25, 34), Arrays.asList(17, 26, 35));

	private List<List<Integer>> vaildRows = Arrays.asList(Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16, 17),
			Arrays.asList(18, 19, 20, 21, 22, 23, 24, 25, 26), Arrays.asList(27, 28, 29, 30, 31, 32, 33, 34, 35));

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

	/**
	 * Adds a column of items in the players inventory, to separate slots into groups
	 * 
	 * @param pos The column index to start at
	 * @param type The type of item to create
	 */
	public void addColoumnSeperator(int pos) {
		for (List<Integer> columns : vaildColumns) {
			if (columns.contains(pos)) {
				for (Integer i : columns) {
					if (i >= pos && !contains(i)) {
						addSlot(new SeparatorSlot(i, new ItemStack(Material.BEDROCK)));
					}
				}
			}
		}
	}

	/**
	 * Adds a row of items in the players inventory, to separate slots into groups
	 * 
	 * @param pos The row index to start at
	 * @param type The type of item to create
	 */
	public void addRowSeperator(int pos) {
		for (List<Integer> rows : vaildRows) {
			if (rows.contains(pos)) {
				for (Integer i : rows) {
					if (i >= pos && !contains(i)) {
						addSlot(new SeparatorSlot(i, new ItemStack(Material.BEDROCK)));
					}
				}
			}
		}
	}

	/* (non-Javadoc)
	 * 
	 * @see belven.toolkits.Closeable#open() */
	@Override
	public void open() {
		for (Slot s : getSlots()) {
			getToolkit().getPlayerInventory().setItem(s.getPosition(), s.getItem());
		}
		setOpen(true);
	}

	/* (non-Javadoc)
	 * 
	 * @see belven.toolkits.Closeable#close() */
	@Override
	public void close() {
		for (Slot s : getSlots()) {
			getToolkit().getPlayerInventory().setItem(s.getPosition(), new ItemStack(Material.AIR));
		}
		setOpen(false);
	}
}
