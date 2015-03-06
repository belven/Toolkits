package belven.toolkits.testimplementations;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import belven.toolkits.Toolkit;
import belven.toolkits.ToolkitManager;

public class TestToolkit extends Toolkit {

	public TestToolkit(ToolkitManager tm, Player player, String name) {
		super(tm, player, name);

		new TestToolbar(this);
		new TestMenu(this);
	}

	@Override
	public void openToolkit() {
		getPlayerInventory().setItem(getOpenButton().getPosition(), new ItemStack(Material.AIR));
		getToolbar().openToolbar();
		getMenu().openMenu();
		getPlayerInventory().setItem(getCloseButton().getPosition(), getCloseButton().getItem());
	}

	@Override
	public void closeToolkit() {
		getPlayerInventory().setItem(getCloseButton().getPosition(), new ItemStack(Material.AIR));
		getToolbar().closeToolbar();
		getMenu().closeMenu();
		getPlayerInventory().setItem(getOpenButton().getPosition(), getOpenButton().getItem());
	}
}