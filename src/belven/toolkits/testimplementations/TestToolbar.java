package belven.toolkits.testimplementations;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Toolbar;
import belven.toolkits.Toolkit;

public class TestToolbar extends Toolbar {

	public TestToolbar(Toolkit toolkit) {
		super(toolkit);

		addSlot(new TestMessageSlot(0, new ItemStack(Material.STONE), "Test 0"));
		addSlot(new TestMessageSlot(1, new ItemStack(Material.STONE), "Test 1"));
		addSlot(new TestMessageSlot(2, new ItemStack(Material.STONE), "Test 2"));
		addSlot(new TestMessageSlot(3, new ItemStack(Material.STONE), "Test 3"));
		addSlot(new TestMessageSlot(4, new ItemStack(Material.STONE), "Test 4"));
		addSlot(new TestMessageSlot(5, new ItemStack(Material.STONE), "Test 5"));
		addSlot(new TestMessageSlot(6, new ItemStack(Material.STONE), "Test 6"));
		addSlot(new TestMessageSlot(7, new ItemStack(Material.STONE), "Test 7"));
	}

}
