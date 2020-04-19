package model;

import lombok.Data;

@Data
public class Coord {
    private double lon;
    private double lat;

    public String toString() {
        return "\n\tGeo coords:"
                + "\n\t\tlongitude = "
                + this.getLon()
                + "\n\t\tlatitude = "
                + this.getLat();
    }
}
