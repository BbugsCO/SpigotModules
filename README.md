# SpigotModules
Random modules for spigot plugins

> ### Class Logger

- logs stuff to a file
- Format:   MM-dd HH:mm:ss message

``` Java
Logger logger = new logger(); // Create logger instance
logger.log(filename, line); // Add line to log
```

> ### Class Config

- Creates a seperate config file
- Good for storing data like player stats or other random stuff

``` Java
Config dataConfig = new configManager("data");  // Will create (or load if exists) a config named data.yml 
dataConfig.getCustomConfig().set(path, value); // Add data to config file
dataConfig.saveCustomConfig(); // Save data to config file
```

> ### Class RegionSaver
- Save and loads areas into a yaml configuration
``` Java
RegionSaver regionSaver = new RegionSaver();  // Will create a class instance
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
