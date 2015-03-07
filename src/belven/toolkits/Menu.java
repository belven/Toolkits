package belven.toolkits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class Menu extends Closeable {
	private List<Page> pages = new ArrayList<>();
	private Toolkit toolkit;
	private int currentIndex = 0;

	public Menu(Toolkit toolkit) {
		this.setToolkit(toolkit);
		toolkit.setMenu(this);
	}

	public Menu(Toolkit toolkit, List<Page> pages) {
		this(toolkit);
		this.pages = pages;
	}

	public List<Slot> getSlots() {
		List<Slot> slots = new ArrayList<>();

		if (pages.size() > 0) {
			slots.addAll(pages.get(currentIndex).getSlots());
		}

		return slots;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	@Override
	public void open() {
		openPage(currentIndex);
		setOpen(true);
	}

	@Override
	public void close() {
		pages.get(currentIndex).close();
		setOpen(false);
	}

	public void addPage(Page newPage) {
		pages.add(newPage);
	}

	public void removePage(Page page) {
		pages.remove(page);
	}

	public void addColoumnSeperator(int pos, Material type) {

	}

	public void addRowSeperator(int pos, Material type) {

	}

	public void openPage(int index) {
		if (index < pages.size() - 1) {
			index = 0;
		} else if (index >= pages.size()) {
			index = 0;
		}

		pages.get(currentIndex).close();
		pages.get(index).open();
		currentIndex = index;
	}

	public Toolkit getToolkit() {
		return toolkit;
	}

	public void setToolkit(Toolkit toolkit) {
		this.toolkit = toolkit;
	}

	public boolean contains(String lore) {
		for (Page p : getPages()) {
			if (p.contains(lore)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int pos) {
		for (Page p : getPages()) {
			if (p.contains(pos)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(ItemStack is) {
		for (Page p : getPages()) {
			if (p.contains(is)) {
				return true;
			}
		}
		return false;
	}

	public Slot getSlot(int pos) {
		for (Page p : getPages()) {
			if (p.contains(pos)) {
				return p.getSlot(pos);
			}
		}
		return null;
	}

	public Slot getSlot(ItemStack is) {
		for (Page p : getPages()) {
			if (p.contains(is)) {
				return p.getSlot(is);
			}
		}
		return null;
	}

	public Slot getSlot(String lore) {
		for (Page p : getPages()) {
			if (p.contains(lore)) {
				return p.getSlot(lore);
			}
		}
		return null;
	}
}