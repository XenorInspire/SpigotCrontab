package fr.nick.crontab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigGenerator {

    public static final String PATH = "plugins" + File.separator + "Crontab" + File.separator;

    private final String header = "# Edit this file to introduce tasks to be run by crontab plugin.\n" +
            "#\n" +
            "# Each task to run has to be defined through a single line\n" +
            "# indicating with different fields when the task will be run\n" +
            "# and what command to run for the task\n" +
            "#\n" +
            "# To define the time you can provide concrete values for\n" +
            "# minute (m), hour (h), day of month (dom), month (mon),\n" +
            "# and day of week (dow) or use '*' in these fields (for 'any').#\n" +
            "# Notice that tasks will be started based on the cron's system\n" +
            "# daemon's notion of time and timezones.\n" +
            "#\n" +
            "# This plugin is basically the same as crontab on linux systems\n" +
            "# The characters '-' or ',' are not recognized yet\n" +
            "#\n" +
            "# Command example :\n" +
            "# At 5 a.m every week :\n" +
            "# 0 5 * * 1 weather clear\n" +
            "#\n" +
            "# m h  dom mon dow   command\n" +
            "\n";

    private final File configPath = new File(PATH);
    private final File configFile = new File(PATH + "config.txt");

    public void initConfig() {

        if (!checkConfigFolder() || !checkConfigFile()) {

            CreateCongigFile();
            System.out.print("The configuration file " + PATH + "config.txt was created");
            System.out.println("Please reload the minecraft server if you want to take account of your modifications");

        }


    }

    private boolean checkConfigFolder() {

        if (configPath.isDirectory() && configPath.exists())
            return true;

        configPath.mkdir();
        return false;

    }

    private boolean checkConfigFile() {

        return configFile.exists() && configFile.isFile();

    }

    private void CreateCongigFile() {

        FileWriter fw;
        try {

            configFile.createNewFile();

            fw = new FileWriter(configFile);
            fw.write(header);
            fw.close();

        } catch (IOException e) {

            System.out.println("Error, Crontab can't create the config file");
            System.exit(1);

        }

    }

}
