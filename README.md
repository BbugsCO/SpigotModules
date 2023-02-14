# SpigotModules
Random modules for spigot plugins

> ### Class Logger

- logs stuff to a file

``` Java
// Create logger instance
Logger logger = new logger();
// Add line to log
logger.log(filename, line);
```

> ### Class Config

- Creates a seperate config file
- Good for storing data like player stats or other random stuff

``` Java
// Create class instance
Config dataConfig = new configManager("data");  // Will create (or load if exists) a config named data.yml 
dataConfig.getCustomConfig().set(path, value); // Add data to config file
dataConfig.saveCustomConfig(); // Save data to config file
```
