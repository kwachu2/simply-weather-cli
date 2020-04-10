package model;

import lombok.Data;

@Data
public class Weather {
    private int id;
    private String main;
    private String description; //to print
    private String icon;

    @Override
    public String toString() {
        return "\n\tWeather Description = " + this.getDescription();
    }
}
