package belven.toolkits.testimplementations;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Page;
import belven.toolkits.Toolkit;

public class TestPage1 extends Page {

	public TestPage1(Toolkit owner) {
		super(owner);

		addSlot(new TestMessageSlot(18, new ItemStack(Material.STONE), "Page Test 1"));
	}

}
