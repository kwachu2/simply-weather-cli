package service;

import model.ReplyJsonList;
import model.Response;

public class PrintWeather {

    private final Response response;

    public PrintWeather(Response response) {
        this.response = response;
    }

    public void printCurrentWeather() {
        System.out.println(this.response);
    }

    public void printWeatherForDateTime(String dateTime) {
        for (ReplyJsonList search : this.response.getReplyJsonList()) {
            if (FormatDate.unixToLocalDateAndTimeString(search.getDt()).equals(dateTime)) {
                System.out.println(search.toString() + this.response.getCity());
            }
        }
    }

    public void printAvailableForecastDateTimes() {
        for (ReplyJsonList search : this.response.getReplyJsonList()) {
            System.out.println(FormatDate.unixToLocalDateAndTimeString(search.getDt()));
        }
    }
}
