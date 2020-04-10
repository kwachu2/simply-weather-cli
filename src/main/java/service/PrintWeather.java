package service;

import lombok.Data;
import model.FormatDate;
import model.List;
import model.ResponseModel;

@Data
public class PrintWeather {

    private ResponseModel responseModel;

    public PrintWeather(ResponseModel responseModel) {
        this.responseModel = responseModel;
    }

    public void printCustomWeather() {
        System.out.println(this.responseModel);
    }

    public void searchAndPrintWeatherForDataTime(String dataTime) {
        for (List search : this.responseModel.getList()) {
            if (FormatDate.unixToLocalDateString(search.getDt()).equals(dataTime)) {
                System.out.println(search.toString() + this.responseModel.getCity());
            }
        }
    }

    public void printAvailableForecastDataTimes() {
        for (List search : this.responseModel.getList()) {
            System.out.println(FormatDate.unixToLocalDateString(search.getDt()));
        }
    }

}
