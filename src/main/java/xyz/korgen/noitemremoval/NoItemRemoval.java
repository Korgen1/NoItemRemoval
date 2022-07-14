package xyz.korgen.noitemremoval;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoItemRemoval extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new events.MoveEvents(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
