package model;

import lombok.Data;

@Data
public class Sys {
    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    private String pod; //forecast version

    public String toString() {
        return "\n\tCountry = " + this.getCountry()
                + "\n\tSunrise = " + FormatDate.unixToLocalTimeString(this.getSunrise())
                + "\n\tSunset = " + FormatDate.unixToLocalTimeString(this.getSunset());
    }
}
