package service;

import model.ReplyJsonList;
import model.Response;
import setup.QueryProperties;
import utils.FormatDate;

public class PrintWeather {

    private final Response response;
    private final QueryProperties queryProperties;

    public PrintWeather(Response response) {
        this.response = response;
        this.queryProperties = new QueryProperties();
    }

    public void printProperties() {
        System.out.println(queryProperties.toPrint());
    }

    public void printCurrentWeather() {
        printProperties();
        System.out.println(this.response.toPrint());
    }

    public void printWeatherForDateTime(String dateTime) {
        printProperties();
        for (ReplyJsonList search : this.response.getReplyJsonList()) {
            if (FormatDate.unixToLocalDateAndTimeString(search.getDt()).equals(dateTime)) {
                System.out.println(search.toPrint() + this.response.getCity().toPrint());
            }
        }
    }

    public void printAvailableForecastDateTimes() {
        printProperties();
        for (ReplyJsonList search : this.response.getReplyJsonList()) {
            System.out.println(FormatDate.unixToLocalDateAndTimeString(search.getDt()));
        }
    }
}
