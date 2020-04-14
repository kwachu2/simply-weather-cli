import lombok.extern.slf4j.Slf4j;
import model.Response;
import org.apache.commons.cli.MissingArgumentException;
import service.HttpWeatherClient;
import service.OptionCli;
import service.PrintWeather;

@Slf4j
public class Main {
    public static void main(String[] args) {

        OptionCli optionCli = new OptionCli(args);

        if (optionCli.getCmd().hasOption("h") || optionCli.getCmd().getOptions().length < 1) {
            optionCli.printHelp();
        } else {
            try {
                HttpWeatherClient httpWeatherClient = new HttpWeatherClient(optionCli.optionBuildQuery());
                Response response = httpWeatherClient.getWeather();
                PrintWeather printWeather = new PrintWeather(response);

                if (optionCli.getDataTime() != null) {
                    printWeather.printWeatherForDateTime(optionCli.getDataTime());
                } else if (response.getReplyJsonList() != null) {
                    printWeather.printAvailableForecastDateTimes();
                } else {
                    printWeather.printCurrentWeather();
                }
            } catch (NullPointerException | MissingArgumentException e) {
                log.info("No data to display");
            }
        }
    }
}
