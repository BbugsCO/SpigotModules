# SpigotModules
Random modules for spigot plugins

> ### Class Logger

- logs stuff to a file

``` Java
// Create logger instance
Logger logger = new logger();
// Add line to log
logger.log(filename, line);

// You could add it to the main plugin class
// In main function:
Logger logger = new logger;
public void log(String filename, String text) { logger.log(filename, text); }
// Access through plugin instance in other classes
plugin.log(filename, text);
```

> ### Class Config

- Creates a seperate config file
- Good for storing data like player stats or other random stuff

``` Java
// Create class instance
Config configManager = new configManager();
// Add data to config
configManager.getCustomConfig().set(path, value);
// Don't forget to save
configManager.saveCustomConfig();

// You could add it to the main plugin class
// In main function:
Config configManager = new configManager();
// You should put createCustomConfig() in onEnable() in main class
public void createCustomConfig() { configManager.createCustomConfig; } 
public FileConfiguration GetCustomConfig() { return configManager.getCustomConfig(); }
public void saveCustomConfig() { configManager.saveCustomConfig();  }
// Example access through plugin instance
plugin.getCustomConfig().set(path, value);
plugin.saveCustomConfig();
```
