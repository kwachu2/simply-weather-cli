package model;

import lombok.Data;

@Data
public class City {
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int population;
    private int timezone;
    private long sunrise;
    private long sunset;

    public String toString() {
        return "\n\tCity name = " + this.getName()
                + this.getCoord()
                + "\n\tCountry = " + this.getCountry()
                + "\n\tPopulation = " + this.getPopulation()
                + "\n\t\tTimezone = " + this.getTimezone()
                + "\n\t\tsunrise = " + FormatDate.unixToLocalTimeString(this.getSunrise())
                + "\n\t\tsunset = " + FormatDate.unixToLocalTimeString(this.getSunset());
    }
}
