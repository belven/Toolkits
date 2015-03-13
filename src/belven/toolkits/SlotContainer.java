package belven.toolkits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.inventory.ItemStack;

/**
 * This is used to manage a collection of {@link Slot}
 * 
 * @author sam
 * 
 */
public abstract class SlotContainer extends Closeable {
	private List<Slot> slots = new ArrayList<Slot>();
	public List<Integer> vailSlots = new ArrayList<Integer>();

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public SlotContainer() {
	}

	public SlotContainer(List<Integer> vailSlots) {
		this.vailSlots = vailSlots;
		// validateSlots();
	}

	public SlotContainer(List<Slot> slots, List<Integer> vailSlots) {
		this.slots = slots;
		this.vailSlots = vailSlots;
		// validateSlots();
	}

	public void validateSlots() {
		Iterator<Slot> iter = slots.iterator();

		while (iter.hasNext()) {
			Slot s = iter.next();

			if (!isSlotValid(s)) {
				slots.remove(s);
			}
		}
	}

	public boolean isSlotValid(Slot s) {
		if (s.getPosition() >= vailSlots.get(0) && s.getPosition() <= vailSlots.get(1)) {
			return true;
		}
		return false;
	}

	public void addSlot(Slot newSlot) {
		slots.add(newSlot);
	}

	public void removeSlot(Slot es) {
		slots.remove(es);
	}

	public void removeSlot(int pos) {
		if (contains(pos)) {
			slots.remove(getSlot(pos));
		}
	}

	public void removeSlot(String name) {
		if (contains(name)) {
			slots.remove(getSlot(name));
		}
	}

	public boolean contains(int pos) {
		for (Slot es : slots) {
			if (es.getPosition() == pos) {
				return true;
			}
		}

		return false;
	}

	public boolean contains(ItemStack is) {
		for (Slot es : slots) {
			if (es.getItem() == is) {
				return true;
			}
		}

		return false;
	}

	public boolean contains(String name) {
		for (Slot es : slots) {
			if (es.getItem().getItemMeta().getLore().get(0) == name) {
				return true;
			}
		}

		return false;
	}

	public Slot getSlot(int pos) {
		for (Slot es : slots) {
			if (es.getPosition() == pos) {
				return es;
			}
		}

		return null;
	}

	public Slot getSlot(String name) {
		for (Slot es : slots) {
			if (es.getName().equals(name)) {
				return es;
			}
		}

		return null;
	}

	public Slot getSlot(ItemStack is) {
		for (Slot es : slots) {
			if (es.getItem() == is) {
				return es;
			}
		}

		return null;
	}

	// public EditSlot getSlot(String type) {
	// for (EditSlot es : slots) {
	// if (es.item.getType() == type) {
	// return es;
	// }
	// }
	//
	// return null;
	// }
}
