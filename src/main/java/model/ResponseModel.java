package model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseModel {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private MainModel main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    //Forecast
    private String message;
    private int cnt;
    private List<model.List> list;
    private City city;


    public String toString() {
        return "ResponseModel: "
                + this.getCoord()
                + this.getWeather().get(0)
                + this.getMain()
                + "\n\tVisibility = " + this.getVisibility()
                + this.getWind()
                + this.getRain()
                + this.getClouds()
                + "\n\tDate Time = " + FormatDate.unixToLocalDateString(this.getDt())
                + this.getSys()
                + "\n\tTimezone = " + this.getTimezone()
                + "\n\tCity name = " + this.getName();
    }
}