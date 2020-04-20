package model;

import lombok.Data;

@Data
public class Coord implements Printable {
    private double lon;
    private double lat;

    @Override
    public String toPrint() {
        return "\n\tGeo coords:"
                + "\n\t\tlongitude = "
                + this.getLon()
                + "\n\t\tlatitude = "
                + this.getLat();
    }
}
