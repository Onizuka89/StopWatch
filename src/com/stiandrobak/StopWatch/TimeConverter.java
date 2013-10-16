package com.stiandrobak.StopWatch;

/**
 * User: stiansd
 * Date: 10.10.13
 * Time: 15:58
 */
public class TimeConverter {
    private final int hours;
    private final int minutes;
    private final int seconds;
    private final int remainder;
    private final int MAX_MINUTES= 60;
    private final int MAX_SECONDS = 60;
    private final int MAX_MILLISECONDS = 1000;
    public TimeConverter(long milliseconds){
        long temp = milliseconds;
        this.hours = (int)(temp / (MAX_MINUTES * MAX_SECONDS * MAX_MILLISECONDS));
        temp = temp - (hours * (MAX_MINUTES * MAX_SECONDS * MAX_MILLISECONDS));
        this.minutes = (int)(temp / (MAX_SECONDS * MAX_MILLISECONDS));
        temp = temp - (minutes * (MAX_SECONDS * MAX_MILLISECONDS));
        this.seconds = (int)(temp / (MAX_MILLISECONDS));
        this.remainder = (int)(temp - (seconds * (MAX_MILLISECONDS)));
    }


    public int getHours(){
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliseconds() {
        return remainder;
    }

    public static String twoDigits(int number){
       return String.format("%02d",number);
    }
    public static String threeDigits(int number){
        return String.format("%03d",number);
    }

    public String toString(){
        return String.format("%02dh:%02dm:%02ds:%03d",hours,minutes,seconds,remainder);
    }
}
