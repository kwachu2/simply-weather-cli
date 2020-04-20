package model;

import lombok.Data;

@Data
public class Wind implements Printable {
    private double speed;
    private int deg;
    private double gust;

    @Override
    public String toPrint() {
        return "\n\tWind: "
                + "\n\t\tspeed = " + this.getSpeed()
                + "\n\t\tdirection = " + this.getDeg()
                + "\n\t\tgust = " + this.getGust();
    }
}
