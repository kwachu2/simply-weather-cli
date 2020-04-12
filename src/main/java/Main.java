
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import model.ResponseModel;
import service.OptionCli;
import service.PrintWeather;

import java.io.IOException;

@Slf4j
public class Main {
    public static void main(String[] args) {

        OptionCli optionCli = new OptionCli(args);

        try {
            if (optionCli.getCmd().hasOption("h") || optionCli.getCmd().getOptions().length < 1) {
                optionCli.helpBuild();
            } else {
                String queryUrl = optionCli.optionBuildQuery();
                System.out.println(queryUrl);
                ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
                HttpResponse<JsonNode> httpResponse = Unirest.get(queryUrl).asJson();
                ResponseModel responseModel = mapper.readValue(httpResponse.getRawBody(), ResponseModel.class);
                PrintWeather printWeather = new PrintWeather(responseModel);

                if (optionCli.getDataTime() != null) {
                    printWeather.searchAndPrintWeatherForDataTime(optionCli.getDataTime());
                } else if (responseModel.getList() != null) {
                    printWeather.printAvailableForecastDataTimes();
                } else {
                    printWeather.printCurrentWeather();
                }
            }
        } catch (UnirestException | IOException | RuntimeException e) {
            log.info("\tInvalid or incomplete parameters. \n\tFor help, type -h or --help");
        }
    }
}
