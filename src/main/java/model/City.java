package model;

import lombok.Data;
import utils.FormatDate;

@Data
public class City implements Printable {
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int population;
    private int timezone;
    private long sunrise;
    private long sunset;

    @Override
    public String toPrint() {
        return "\n\tCity name = " + this.getName()
                + this.getCoord().toPrint()
                + "\n\tCountry = " + this.getCountry()
                + "\n\tPopulation = " + this.getPopulation()
                + "\n\t\tTimezone = " + this.getTimezone()
                + "\n\t\tsunrise = " + FormatDate.unixToLocalTimeString(this.getSunrise())
                + "\n\t\tsunset = " + FormatDate.unixToLocalTimeString(this.getSunset());

    }

}
