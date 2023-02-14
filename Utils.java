package domain.name.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    // Converts String value to Location (format:x-y-z-world)
    public Location stringToLocation(String s) {
        ArrayList<String> position = new ArrayList<String>(List.of(s.split("-")));
        return new Location(Bukkit.getWorld(position.get(3)), Double.parseDouble(position.get(0)), Double.parseDouble(position.get(1)), Double.parseDouble(position.get(2)));
    }


    // Convert Location to String (format:x-y-z-world)
    public String locationToString(Location l) {
        return l.getBlockX() + "-" + l.getBlockY() + "-" + l.getBlockZ() + "-" + l.getWorld().toString();
    }

    // Tests to see if String is numeric
    public Boolean isNumeric(String s) {
        try {
            Double d = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    // Generate a random integer in range [min, max]
    public int randomNumber(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
