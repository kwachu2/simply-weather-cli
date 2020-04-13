package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import service.FormatDate;

@Data
public class Sys {
    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    @JsonProperty("pod")
    private String podForecast;

    public String toString() {
        return "\n\tCountry = " + this.getCountry()
                + "\n\tSunrise = " + FormatDate.unixToLocalTimeString(this.getSunrise())
                + "\n\tSunset = " + FormatDate.unixToLocalTimeString(this.getSunset());
    }
}
