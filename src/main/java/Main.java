import service.HttpWeatherClient;
import service.OptionCli;
import service.PrintWeather;

public class Main {
    public static void main(String[] args) {

        OptionCli optionCli = new OptionCli(args);

        if (optionCli.getCmd().hasOption("h") || optionCli.getCmd().getOptions().length < 1) {
            optionCli.printHelp();
        } else {
            new PrintWeather(optionCli, new HttpWeatherClient(optionCli).getWeather()).print();
        }
    }
}
