package model;

import lombok.Data;

@Data
public class Wind {
    private double speed;
    private int deg;
    private double gust;

    public String toString() {
        return "\n\tWind: "
                + "\n\t\tspeed = " + this.getSpeed()
                + "\n\t\tdirection = " + this.getDeg()
                + "\n\t\tgust = " + this.getGust();
    }
}
