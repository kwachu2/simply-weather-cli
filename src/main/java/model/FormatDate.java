package model;

public class FormatDate {
    public static String unixToLocalDateString(Long dt) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(dt * 1000));
    }

    public static String unixToLocalTimeString(Long dt) {
        return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date(dt * 1000));
    }
}
