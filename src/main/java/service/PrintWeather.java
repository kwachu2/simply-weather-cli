package service;

import model.FormatDate;
import model.ReplyJsonList;
import model.Response;

public class PrintWeather {

    private final Response response;
    private final OptionCli optionCli;

    public PrintWeather(OptionCli optionCli, Response response) {
        this.optionCli = optionCli;
        this.response = response;
    }

    private void printCurrentWeather() {
        System.out.println(this.response);
    }

    private void printWeatherForDateTime(String dateTime) {
        for (ReplyJsonList search : this.response.getReplyJsonList()) {
            if (FormatDate.unixToLocalDateString(search.getDt()).equals(dateTime)) {
                System.out.println(search.toString() + this.response.getCity());
            }
        }
    }

    private void printAvailableForecastDateTimes() {
        for (ReplyJsonList search : this.response.getReplyJsonList()) {
            System.out.println(FormatDate.unixToLocalDateString(search.getDt()));
        }
    }

    public void print() {

        if (optionCli.getDataTime() != null) {
            printWeatherForDateTime(optionCli.getDataTime());
        } else if (response.getReplyJsonList() != null) {
            printAvailableForecastDateTimes();
        } else {
            printCurrentWeather();
        }

    }

}
