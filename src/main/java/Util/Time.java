package Util;

public class Time {
    private int hour;
    private int minutes;
    private int seconds;

    public int getHour() { return hour; }
    public int getMinutes() { return minutes; }
    public int getSeconds() { return  seconds; }

    public Time (int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}
