package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import utils.FormatDate;

import java.util.List;

@Data
public class Response implements Printable {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private ReplyJsonMain main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    private String message;
    private int cnt;
    @JsonProperty("list")
    private List<ReplyJsonList> replyJsonList;
    private City city;


    private String getRainToPrint() {
        if (this.rain == null) {
            return "no rain";
        } else {
            return this.rain.toPrint();
        }
    }

    @Override
    public String toPrint() {
        return "Current weather for " + this.getName()
                + this.getCoord().toPrint()
                + this.getWeather().get(0).toPrint()
                + this.getMain().toPrint()
                + "\n\tVisibility = " + this.getVisibility()
                + this.getWind().toPrint()
                + "\n\tRain: "
                + getRainToPrint()
                + this.getClouds().toPrint()
                + "\n\tDate Time = " + FormatDate.unixToLocalDateAndTimeString(this.getDt())
                + this.getSys().toPrint()
                + "\n\tTimezone = " + this.getTimezone()
                + "\n\tCity name = " + this.getName();
    }

}