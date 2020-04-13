import lombok.extern.slf4j.Slf4j;
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
                new PrintWeather(optionCli, new HttpWeatherClient(optionCli).getWeather()).print();
            } catch (NullPointerException e) {
                log.info("No data to display");
            }
        }
    }
}
