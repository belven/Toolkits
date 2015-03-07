package belven.toolkits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * A menu contains a collection of {@link Page}, and has several methods for accessing them This makes the players backpack inventory into a
 * menu system with usable buttons
 * 
 * @author sam
 * 
 */
public abstract class Menu extends Closeable {
	private List<Page> pages = new ArrayList<>();
	private Toolkit toolkit;
	private int currentIndex = 0;

	public Toolkit getToolkit() {
		return toolkit;
	}

	public void setToolkit(Toolkit toolkit) {
		this.toolkit = toolkit;
	}

	/**
	 * This maintains the current page index, i.e. the page that is currently open
	 * 
	 * @return The current pages index
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}

	/**
	 * Sets the current page index
	 * 
	 * @param currentIndex the new page index
	 */
	private void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	/**
	 * Get all the pages stored in the menu
	 * 
	 * @return All the menu pages
	 */
	public List<Page> getPages() {
		return pages;
	}

	/**
	 * Sets the menus pages
	 * 
	 * @param pages The pages to assign
	 */
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public Menu(Toolkit toolkit) {
		this.setToolkit(toolkit);
		toolkit.setMenu(this);
	}

	public Menu(Toolkit toolkit, List<Page> pages) {
		this(toolkit);
		this.pages = pages;
	}

	/**
	 * Get the current slots in the menu
	 * 
	 * @return The current pages slots
	 */
	public List<Slot> getSlots() {
		List<Slot> slots = new ArrayList<>();

		if (pages.size() > 0) {
			slots.addAll(pages.get(currentIndex).getSlots());
		}

		return slots;
	}

	/* (non-Javadoc)
	 * 
	 * @see belven.toolkits.Closeable#open() */
	@Override
	public void open() {
		openPage(currentIndex);
		setOpen(true);
	}

	/* (non-Javadoc)
	 * 
	 * @see belven.toolkits.Closeable#close() */
	@Override
	public void close() {
		pages.get(currentIndex).close();
		setOpen(false);
	}

	/**
	 * Adds a new page to the menu
	 * 
	 * @param newPage the new page to add
	 */
	public void addPage(Page newPage) {
		pages.add(newPage);
	}

	/**
	 * Removes a page from the menu
	 * 
	 * @param page the page to remove
	 */
	public void removePage(Page page) {
		pages.remove(page);
	}

	/**
	 * Adds a column of items in the players inventory, to separate slots into groups
	 * 
	 * @param pos The column index to start at
	 * @param type The type of item to create
	 */
	public void addColoumnSeperator(int pos, Material type) {

	}

	/**
	 * Adds a row of items in the players inventory, to separate slots into groups
	 * 
	 * @param pos The row index to start at
	 * @param type The type of item to create
	 */
	public void addRowSeperator(int pos, Material type) {

	}

	/**
	 * Opens a page at the given index
	 * 
	 * @param index the index of hte page to go to
	 */
	public void openPage(int index) {
		if (index < pages.size() - 1) {
			index = 0;
		} else if (index >= pages.size()) {
			index = 0;
		}

		pages.get(currentIndex).close();
		pages.get(index).open();
		setCurrentIndex(index);
	}

	/**
	 * Checks to see if the current {@link Page} has a {@link Slot} with a particular inventory position
	 * 
	 * @param lore The lore to check for a {@link Slot}
	 * @return If the {@link Page} contains the {@link Slot}
	 */
	public boolean contains(String lore) {
		if (pages.get(currentIndex) != null && pages.get(currentIndex).contains(lore)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if the current {@link Page} has a {@link Slot} with a particular inventory position
	 * 
	 * @param pos The position to check for a {@link Slot}
	 * @return If the {@link Page} contains the {@link Slot}
	 */
	public boolean contains(int pos) {
		if (pages.get(currentIndex) != null && pages.get(currentIndex).contains(pos)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if the current {@link Page} has a {@link Slot} with a particular inventory position
	 * 
	 * @param is The {@link ItemStack} to check for a {@link Slot}
	 * @return If the {@link Page} contains the {@link Slot}
	 */
	public boolean contains(ItemStack is) {
		if (pages.get(currentIndex) != null && pages.get(currentIndex).contains(is)) {
			return true;
		}
		return false;
	}

	/**
	 * Looks through the current {@link Page} and gets the relevant {@link Slot}
	 * 
	 * @param pos The {@link Slot} position to check for
	 * @return The {@link Slot} found if any
	 */
	public Slot getSlot(int pos) {
		if (contains(pos)) {
			return pages.get(currentIndex).getSlot(pos);
		}
		return null;
	}

	/**
	 * Looks through the current {@link Page} and gets the relevant {@link Slot}
	 * 
	 * @param is The {@link Slot} ItemStack to check for
	 * @return The {@link Slot} found if any
	 */
	public Slot getSlot(ItemStack is) {
		if (contains(is)) {
			return pages.get(currentIndex).getSlot(is);
		}
		return null;
	}

	/**
	 * Looks through the current {@link Page} and gets the relevant {@link Slot}
	 * 
	 * @param lore The {@link Slot} lore to check for
	 * @return The {@link Slot} found if any
	 */
	public Slot getSlot(String lore) {
		if (contains(lore)) {
			return pages.get(currentIndex).getSlot(lore);
		}
		return null;
	}
}