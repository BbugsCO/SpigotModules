# SpigotModules
Random modules I use for spigot plugins

> ### Class Logger

- logs stuff to a file
- Format:   MM-dd HH:mm:ss message

``` Java
logger.log(filename, line); // Add line to log
```

> ### Class ConfigManager

- Creates a seperate config file
- Good for storing data like player stats or other random stuff

``` Java
ConfigManager dataConfig = new ConfigManager("data"); // Create class instance 
dataConfig.createCustomConfig(); // Will create (or load if exists) a config named data.yml 
dataConfig.getCustomConfig().set(path, value); // Add data to config file
dataConfig.saveCustomConfig(); // Save data to config file
```

> ### Class RegionSaver
- Save and loads areas into a yaml configuration
``` Java
/*
* Saves a region to yaml file
*
* @param path save path in yaml configuration
* @param loc1 Location #1
* @param loc2 Location #2    
*/
regionSaver.save(path, location1, location2)
/*
* Loads a region from yaml file
*
* @param loadLocation location in which to be saved, starting at itself and going towards positive x, y, z
* @param path path to pre-existing yaml save
*/
regionSaver.load(loadLocation, path)
```

> ### Class Utils
- Random utility functions that I use
#### function stringToLocation()
- Good for saving locations as text
```Java
/**
* Converts a string to location
* format must be:  "x-y-z-world"
*
* @param location (String) value of a location
*
* @return Location
*/
Utils.stringToLocation("1-2-3-world");
// returns Location type
```
#### function locationToString()
```Java
/**
* Converts a location
* formatted as "x-y-z-world"
*
* @param location location
*
* @return Formatted string of location
*/
utils.locationToString(location);
```
#### function isNumeric()
```Java
/**
* Tests to see if a string value is numeric
*
* @param value string to test if numeric
*
* @return Bool
*/
utils.isNumeric("2");
// returns true
```
#### function randomNumber()
- Includes min, max, and anything inbetween
```Java
/**
* Generates random number
*
* @param min minimum number in range
* @param max maximum number in range
*
* @return random int
*/
utils.randomNumber(1, 10);
```
> ### Class AttackCooldown
- Option to add change to 1.8.9 PVP attack speeds
- Checks key "old_pvp" in plugin default config.yml
- key "old_pvp" value is boolean (true/false)
