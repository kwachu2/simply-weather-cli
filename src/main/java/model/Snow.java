package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Snow {
    @JsonProperty("1h")
    private double oneHours;
    @JsonProperty("3h")
    private double threeHours;

    public String toString() {
        return " \n\t\t1h = " + this.getOneHours()
                + "\n\t\t3h = " + this.getThreeHours();
    }
}
