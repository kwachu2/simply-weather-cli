package model;

import lombok.Data;

@Data
public class Weather implements Printable {
    private int id;
    private String main;
    private String description;
    private String icon;

    @Override
    public String toPrint() {
        return "\n\tWeather Description = " + this.getDescription();
    }
}
