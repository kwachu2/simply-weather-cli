package service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public static final SimpleDateFormat formatterDateAndTime = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    public static final SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

    public static String unixToLocalDateAndTimeString(Long dt) {
        return formatterDateAndTime.format(new Date(dt * 1000));
    }

    public static String unixToLocalTimeString(Long dt) {
        return formatterTime.format(new Date(dt * 1000));
    }
}
