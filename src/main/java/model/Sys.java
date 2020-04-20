package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import utils.FormatDate;

@Data
public class Sys implements Printable {
    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    @JsonProperty("pod")
    private String podForecast;

    @Override
    public String toPrint() {
        return "\n\tCountry = " + this.getCountry()
                + "\n\tSunrise = " + FormatDate.unixToLocalTimeString(this.getSunrise())
                + "\n\tSunset = " + FormatDate.unixToLocalTimeString(this.getSunset());
    }
}
