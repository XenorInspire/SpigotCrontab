package fr.nick.crontab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.Bukkit.getServer;

public class MinecraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        return getServer().dispatchCommand(getServer().getConsoleSender(), "save-all");
    }
}
