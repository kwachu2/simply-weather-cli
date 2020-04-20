package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Snow implements Printable {
    @JsonProperty("1h")
    private double oneHours;
    @JsonProperty("3h")
    private double threeHours;

    @Override
    public String toPrint() {
        return " \n\t\t1h = " + this.getOneHours()
                + "\n\t\t3h = " + this.getThreeHours();
    }
}
