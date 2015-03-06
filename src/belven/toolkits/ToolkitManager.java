package belven.toolkits;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import belven.toolkits.listeners.PlayerListener;
import belven.toolkits.testimplementations.TestToolkit;

public class ToolkitManager extends JavaPlugin {
	private final PlayerListener playerListener = new PlayerListener(this);

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(playerListener, this);
	}

	private HashMap<Player, Toolkit> toolkits = new HashMap<>();

	public HashMap<Player, Toolkit> getToolkits() {
		return toolkits;
	}

	public void setToolkits(HashMap<Player, Toolkit> toolkits) {
		this.toolkits = toolkits;
	}

	public Toolkit getToolkit(Player p) {
		return toolkits.get(p);
	}

	public void CreateTestToolkit(Player p) {
		new TestToolkit(this, p, "Test Toolkit Yo");
	}
}