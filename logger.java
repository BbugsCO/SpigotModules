package domain.name.plugin.config;

import org.bukkit.Bukkit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class logger {
    public static void log(String filename, String message) {
        try {
            // Get Folder
            File dataFolder = Bukkit.getServer().getPluginManager().getPlugin("pluginname").getDataFolder();
            if(!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            // Get File
            String logFileName = filename + ".log";
            File file = new File(Bukkit.getServer().getPluginManager().getPlugin("pluginname").getDataFolder(), logFileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);

            // Generate Timestamp
            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss");
            String time = format.format(now);

            // Set Formatted Message
            String formattedMessage = time + " " + message;

            // Write to File
            pw.println(formattedMessage);
            pw.flush();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
