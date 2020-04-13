package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");

    public static String unixToLocalDateString(Long dt) {
        return formatter.format(new Date(dt * 1000));
    }

    public static String unixToLocalTimeString(Long dt) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(dt * 1000)); // todo
    }
}
