package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReplyJsonMain {

    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    private double pressure;
    private double humidity;

    @JsonProperty("sea_level")
    private double seaLevel; //coord version
    @JsonProperty("grnd_level")
    private double grndLevel; //coord version

    @JsonProperty("temp_kf")
    private double tempKf; //forecast version

    public String toString() {
        return "\n\tTemperature = " + this.getTemp()
                + "\n \tFeels like = " + this.getFeelsLike()
                + "\n \tTemp min = " + this.getTempMin()
                + "\n \tTemp max = " + this.getTempMax()
                + "\n \tPressure = " + this.getPressure()
                + "\n \tHumidity = " + this.getHumidity()
                + "\n \tPressure on the sea level = " + this.getSeaLevel()
                + "\n \tPressure on the ground level = " + this.getGrndLevel()
                + "\n \ttemp_kf = " + this.getTempKf();
    }
}
