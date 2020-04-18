package co.mc520.house;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class House extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        if (command.getName().equalsIgnoreCase("house")){
            if (!(sender instanceof Player)){
                sender.sendMessage("§9§l家园系统§e§l>> §e只有玩家才可以执行此指令");
            }else {
                if (sender.hasPermission("house.use")) {
                    Bukkit.getServer().dispatchCommand((CommandSender) player, getConfig().getString("house"));
                } else {
                    sender.sendMessage("&9&l家园系统&c&l>> &c您没有权限这样做");
                }
            }
        }
        if (command.getName().equalsIgnoreCase("gethouse")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§9§l家园系统§e§l>> §e只有玩家才可以执行此指令");
            } else {
                if (sender.hasPermission("house.use")) {
                    Bukkit.getServer().dispatchCommand((CommandSender) player, getConfig().getString("gethouse"));
                } else {
                    sender.sendMessage("&9&l家园系统&c&l>> &c您没有权限这样做");
                }
            }
        }
        return false;
    }
}
