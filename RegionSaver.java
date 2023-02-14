package domain.name.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class RegionSaver {
    Config dataConfig = new Config("data");

    /**
     * Saves a region to yaml file
     *
     * @param path save path in yaml configuration
     * @param loc1 Location #1
     * @param loc2 Location #2
     */
    public boolean save(String path, Location loc1, Location loc2) {
        if (!loc1.getWorld().getName().equals(loc2.getWorld().getName())) { return false; }
        World world = loc1.getWorld();
        // Min and Max for each axis
        int minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        int maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        int minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        int maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        int minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        int maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());

        /*
        Save each coordinate formatted as:   x-y-z
        min x, min y, min z = (0, 0, 0)

        Saved to config as:
         path:
           blocks:
             x-y-z: stone

         */

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                     String material = world.getBlockAt(x, y, z).getType().toString();
                     String pos = x + "-" + y + "-" + z;
                     if (!Material.valueOf(material).equals(Material.AIR)) { dataConfig.getCustomConfig().set(path + ".blocks." + pos, material);  }
                }
            }
        }
        return true;
    }

    /**
     * Loads a region from yaml file
     *
     * @param loadLocation location in which to be saved, starting at itself and going towards positive x, y, z
     * @param path path to pre-existing yaml save
     */
    public boolean load(Location loadLocation, String path) {
        int startX = loadLocation.getBlockX();
        int startY = loadLocation.getBlockY();
        int startZ = loadLocation.getBlockZ();
        World world = loadLocation.getWorld();

        ConfigurationSection blocks = dataConfig.getCustomConfig().getConfigurationSection(path + ".blocks");

        if (!dataConfig.getCustomConfig().contains(path + ".blocks")) { return false; }

        for (String pos : blocks.getKeys(false)) {
            String fullPath = path + ".blocks." + pos;
            Material m = Material.valueOf(dataConfig.getCustomConfig().getString(fullPath));
            ArrayList<String> position = new ArrayList<String>(List.of(pos.split("-")));
            int x = Integer.parseInt(position.get(0)) + startX;
            int y = Integer.parseInt(position.get(1)) + startY;
            int z = Integer.parseInt(position.get(2)) + startZ;
            world.getBlockAt(x, y, z).setType(m);
        }
        return true;
    }
}
