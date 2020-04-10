package model;

import lombok.Data;

@Data
public class MainModel {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double humidity;

    private double sea_level; //coord version
    private double grnd_level; //coord version

    private double temp_kf; //forecast version

    public String toString() {
        return "\n\tTemperature = " + this.getTemp()
                + "\n \tFeels like = " + this.getFeels_like()
                + "\n \tTemp min = " + this.getTemp_min()
                + "\n \tTemp max = " + this.getTemp_max()
                + "\n \tPressure = " + this.getPressure()
                + "\n \tHumidity = " + this.getHumidity()
                + "\n \tPressure on the sea level = " + this.getSea_level()
                + "\n \tPressure on the ground level = " + this.getGrnd_level()
                + "\n \ttemp_kf = " + this.getTemp_kf();
    }
}
