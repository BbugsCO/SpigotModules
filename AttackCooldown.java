package domain.name.plugin;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AttackCooldown implements Listener {

    private final double attackSpeed;
    /*
    * Checks for key old_pvp in default plugin config.yml
    * If true: attack speed = 40 (1.8.9 PVP)
    * If false: attack speed = 4 (1.9+ PVP)
    */
    public attackCooldown(pluginName plugin) {
        if (plugin.getConfig().getBoolean("old_pvp")) {
            attackSpeed = 40;
        } else {
            attackSpeed = 4;
        }
    }

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent e) {
        setAttackSpeed(e.getPlayer(), attackSpeed);
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        setAttackSpeed(e.getPlayer(), attackSpeed);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        setAttackSpeed(e.getPlayer(), 4);
    }

    public static void setAttackSpeed(Player player, double attackSpeed) {
        final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        if (attribute == null) return;

        final double baseValue = attribute.getBaseValue();

        if (baseValue != attackSpeed) {
            attribute.setBaseValue(attackSpeed);
            player.saveData();
        }
    }
}
