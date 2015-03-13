package belven.toolkits.testimplementations;

import org.bukkit.entity.Player;

import belven.toolkits.Toolkit;
import belven.toolkits.ToolkitManager;

public class TestToolkit extends Toolkit {

	public TestToolkit(ToolkitManager tm, Player player, String name) {
		super(tm, player, name);

		new TestToolbar(this);
		new TestMenu(this);
	}

	@Override
	public void open() {
		super.open();
	}

	@Override
	public void close() {
		super.close();
	}
}