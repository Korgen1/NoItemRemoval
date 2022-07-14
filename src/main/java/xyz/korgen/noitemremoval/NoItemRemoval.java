package xyz.korgen.noitemremoval;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class NoItemRemoval extends JavaPlugin {

    public static NoItemRemoval plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new events.MoveEvents(), this);

        List<String> list = new ArrayList<>();
        list.add("DIRT");
        list.add("COBBLESTONE");

        FileConfiguration config = this.getConfig();
        config.addDefault("whitelist", list);
        config.options().copyDefaults(true);
        saveConfig();

        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
