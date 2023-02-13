# SpigotModules
random modules for spigot plugins

> class logger

- logs stuff to a file

``` Java
# Create logger instance
Logger logger = new logger;
# Add line to log
logger.log(filename, line);

# You could add it to the main plugin class
# In main function:
Logger logger = new logger;
public void log(String filename, String text) { logger.log(filename, text); }
# Access through plugin instance
plugin.log(filename, text);

```

