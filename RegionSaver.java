package domain.name.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class RegionSaver {
    Config dataConfig = new Config("data");

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
        Save each coordinate formatted as:   x-y-z-world
        min x, min y, min z = (0, 0, 0)

        Saved to config as:
         path:
           blocks:
             x-y-z-world: stone

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
    // Will load starting at saveLoc and will go towards positive x, y, z
    public boolean load(Location saveLoc, String path) {
        int startX = saveLoc.getBlockX();
        int startY = saveLoc.getBlockY();
        int startZ = saveLoc.getBlockZ();
        World world = saveLoc.getWorld();

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
