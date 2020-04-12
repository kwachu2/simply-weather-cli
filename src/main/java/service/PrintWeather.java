package service;

import lombok.Data;
import model.FormatDate;
import model.ReplyJsonList;
import model.ResponseModel;

@Data
public class PrintWeather {

    private final ResponseModel responseModel;

    public PrintWeather(ResponseModel responseModel) {
        this.responseModel = responseModel;
    }

    public void printCurrentWeather() {
        System.out.println(this.responseModel);
    }

    public void printWeatherForDateTime(String dateTime) {
        for (ReplyJsonList search : this.responseModel.getReplyJsonList()) {
            if (FormatDate.unixToLocalDateString(search.getDt()).equals(dateTime)) {
                System.out.println(search.toString() + this.responseModel.getCity());
            }
        }
    }

    public void printAvailableForecastDateTimes() {
        for (ReplyJsonList search : this.responseModel.getReplyJsonList()) {
            System.out.println(FormatDate.unixToLocalDateString(search.getDt()));
        }
    }

}
