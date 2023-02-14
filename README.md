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
