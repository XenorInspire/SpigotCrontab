package fr.nick.crontab;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;

public final class Crontab extends JavaPlugin {

    @Override
    public void onEnable() {

        ConfigGenerator cg = new ConfigGenerator();
        cg.initConfig();

        CommandCreator cc = new CommandCreator(ConfigGenerator.PATH + "config.txt");
        System.out.println("Crontab started successfully");
        cc.setCommands();

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.runTask(this, new Runnable() {
            @Override
            public void run() {

                ArrayList<Command> userCommands = onBoot(cc.getCrontabCommands());

            }
        });

    }

    public ArrayList<Command> onBoot(ArrayList<Command> commands) {

        for (int i = 0; i < commands.size(); i++) {

            if (commands.get(i).isReboot()) {

                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), commands.get(i).getCommand());
                commands.remove(i);
                i--;

            }

        }

        return commands;

    }

    @Override
    public void onDisable() {

        System.out.println("Crontab is shutting down");

    }
}
