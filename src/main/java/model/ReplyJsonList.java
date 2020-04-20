package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import utils.FormatDate;

import java.util.List;

@Data
public class ReplyJsonList implements Printable {
    private long dt;
    private ReplyJsonMain main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Sys sys;
    @JsonProperty("dt_txt")
    private String dtTxt;


    private String getRainToPrint() {
        if (this.rain == null) {
            return "no rain";
        } else {
            return this.rain.toPrint();
        }
    }

    private String getSnowToPrint() {
        if (this.rain == null) {
            return "no snow";
        } else {
            return this.snow.toPrint();
        }
    }

    @Override
    public String toPrint() {
        return "Date: "
                + FormatDate.unixToLocalDateAndTimeString(this.getDt())
                + this.getMain().toPrint()
                + "\n"
                + this.getWeather().get(0).toPrint()
                + this.getClouds().toPrint()
                + this.getWind().toPrint()
                + "\n\tRain: "
                + getRainToPrint()
                + "\n\tSnow: "
                + getSnowToPrint()
                + "\n"
                + "\tUTC = "
                + this.getDtTxt() + "\n";
    }

}
