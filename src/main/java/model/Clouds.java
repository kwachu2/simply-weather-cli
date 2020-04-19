package model;

import lombok.Data;

@Data
public class Clouds {
    private double all;

    public String toString() {
        return "\n\tCloudiness(%) = " + this.getAll();
    }
}
