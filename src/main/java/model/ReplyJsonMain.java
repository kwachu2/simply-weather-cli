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
    private double seaLevelCoord;
    @JsonProperty("grnd_level")
    private double grndLevelCoord;

    @JsonProperty("temp_kf")
    private double tempKfForecast;

    public String toString() {
        return "\n\tTemperature = " + this.getTemp()
                + "\n \tFeels like = " + this.getFeelsLike()
                + "\n \tTemp min = " + this.getTempMin()
                + "\n \tTemp max = " + this.getTempMax()
                + "\n \tPressure = " + this.getPressure()
                + "\n \tHumidity = " + this.getHumidity()
                + "\n \tPressure on the sea level = " + this.getSeaLevelCoord()
                + "\n \tPressure on the ground level = " + this.getGrndLevelCoord()
                + "\n \ttemp_kf = " + this.getTempKfForecast();
    }
}
