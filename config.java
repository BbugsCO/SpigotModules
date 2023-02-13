package domain.name.plugin.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class config {

    private File customConfigFile;
    private FileConfiguration customConfig;

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    public void createCustomConfig(String filename) {
        customConfigFile = new File(Bukkit.getServer().getPluginManager().getPlugin("pluginname").getDataFolder(), "data.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            Bukkit.getServer().getPluginManager().getPlugin("pluginname").saveResource("data.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveCustomConfig() {
        try {
            customConfig.save(customConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
