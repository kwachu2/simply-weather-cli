package model;

import lombok.Data;

@Data
public class Clouds implements Printable {
    private double all;

    @Override
    public String toPrint() {
        return "\n\tCloudiness(%) = " + this.getAll();
    }
}
