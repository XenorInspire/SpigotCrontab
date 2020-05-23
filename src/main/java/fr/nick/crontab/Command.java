package fr.nick.crontab;

public class Command {

    private String command;
    private String m;
    private String h;
    private String dom;
    private String mon;
    private String dow;
    private boolean reboot;

    public Command(String command, String m, String h, String dom, String mon, String dow, boolean reboot) {

        this.command = command;
        this.m = m;
        this.h = h;
        this.dom = dom;
        this.mon = mon;
        this.dow = dow;
        this.reboot = reboot;

    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public boolean isReboot() {
        return reboot;
    }

    public void setReboot(boolean reboot) {
        this.reboot = reboot;
    }

    @Override
    public String toString() {
        return "Command{" +
                "command='" + command + '\'' +
                ", m='" + m + '\'' +
                ", h='" + h + '\'' +
                ", dom='" + dom + '\'' +
                ", mon='" + mon + '\'' +
                ", dow='" + dow + '\'' +
                ", reboot=" + reboot +
                '}';
    }
}
