package domain.name.plugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * Converts a string to location
     * format must be:  "x-y-z-world"
     *
     * @param location string value of a location
     *
     * @return Location
     */
    public Location stringToLocation(String location) {
        ArrayList<String> position = new ArrayList<>(List.of(location.split("-")));
        if (position.size() != 4) { return null; }
        return new Location(Bukkit.getWorld(position.get(3)), Double.parseDouble(position.get(0)), Double.parseDouble(position.get(1)), Double.parseDouble(position.get(2)));
    }

    /**
     * Converts a location
     * formatted as "x-y-z-world"
     *
     * @param location location
     *
     * @return Formatted string of location
     */
    public String locationToString(Location location) {
        return location.getBlockX() + "-" + location.getBlockY() + "-" + location.getBlockZ() + "-" + location.getWorld().toString();
    }


    /**
     * Tests to see if a string value is numeric
     *
     * @param value string to test if numeric
     *
     * @return Bool
     */
    public Boolean isNumeric(String value) {
        try {
            Double d = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Generates random number
     * 
     * @param min minimum number in range
     * @param max maximum number in range
     *
     * @return random int
     */
    public int randomNumber(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
