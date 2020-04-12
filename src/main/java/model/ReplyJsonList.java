package model;

import lombok.Data;
import java.util.List;

@Data
public class ReplyJsonList {
    private long dt;
    private MainModel main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Sys sys;
    private String dt_txt;

    @Override
    public String toString() {
        return "Date: "
                + FormatDate.unixToLocalDateString(this.getDt())
                + this.getMain()
                + "\n"
                + this.getWeather().get(0)
                + this.getClouds()
                + this.getWind()
                + "\n\tRain: "
                + this.getRain() // check null value
                + "\n\tSnow: "
                + this.getSnow()
                + "\n"
                + "\tUTC = "
                + this.getDt_txt() + "\n";
    }
}
