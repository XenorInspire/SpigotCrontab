package fr.nick.crontab;

import java.io.*;
import java.util.ArrayList;

public class CommandCreator {

    private final ArrayList<String> commands = new ArrayList<String>();
    private final ArrayList<Command> crontabCommands = new ArrayList<Command>();

    public CommandCreator(String path) {

        BufferedReader br;
        File configFile = new File(path);
        String temp;

        try {
            br = new BufferedReader(new FileReader(configFile));

            while ((temp = br.readLine()) != null) {
                if (temp.length() >=1 && temp.charAt(0) != '#')
                    commands.add(temp);
            }

            br.close();

        } catch (FileNotFoundException e) {

            System.out.println("Error, Crontab can't found the config file");
            System.exit(1);

        } catch (IOException e) {

            System.out.println("Error, Crontab can't read the config file");
            System.exit(1);

        }

    }

    public void setCommands() {

        for (int i = 0; i < commands.size(); i++) {

            String[] temp = commands.get(i).split(" ");
            int keywords = isShortcut(temp[0]);
            String command;

            if (keywords != 0) {

                crontabCommands.add(allocate(keywords, temp));
                continue;

            }

            try {

                command = temp[5];

                if (temp.length > 6) {

                    for (int j = 6; j < temp.length; j++)
                        command += " " + temp[j];

                }

                crontabCommands.add(new Command(command, temp[0], temp[1], temp[2], temp[3], temp[4], false));

            } catch (Exception e) {

                System.out.print("Invalid command " + (i + 1) + " : " + commands.get(i));

            }

        }

    }

    private int isShortcut(String firstArg) {

        switch (firstArg) {

            case "@reboot":
                return 1;

            case "@yearly":

            case "@annually":
                return 2;

            case "@monthly":
                return 3;

            case "@weekly":
                return 4;

            case "@daily":

            case "@midnight":
                return 5;

            case "@hourly":
                return 6;

            default:
                return 0;

        }

    }

    private Command allocate(int mode, String[] temp) {

        Command finalCommand = null;
        String command = temp[1];

        if (temp.length > 2) {

            for (int i = 2; i < temp.length; i++)
                command += " " + temp[i];

        }

        switch (mode) {

            case 1:
                finalCommand = new Command(command, null, null, null, null, null, true);
                break;

            case 2:
                finalCommand = new Command(command, "0", "0", "1", "1", "*", false);
                break;

            case 3:
                finalCommand = new Command(command, "0", "0", "1", "*", "*", false);
                break;

            case 4:
                finalCommand = new Command(command, "0", "0", "*", "*", "0", false);
                break;

            case 5:
                finalCommand = new Command(command, "0", "0", "*", "*", "*", false);
                break;

            case 6:
                finalCommand = new Command(command, "0", "*", "*", "*", "*", false);
                break;

        }

        return finalCommand;

    }

    public ArrayList<Command> getCrontabCommands() {

        return crontabCommands;

    }
}
