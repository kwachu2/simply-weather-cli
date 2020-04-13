package service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Data
public class OptionCli {
    private final String[] arguments;
    private final CommandLineParser parser;
    private String dataTime;
    private Options options;
    private CommandLine cmd;
    private boolean isForecast;

    public OptionCli(String[] arguments) {
        this.arguments = arguments;
        this.parser = new DefaultParser();
        this.options = optionsBuild();
        this.isForecast = false;
        try {
            this.cmd = parser.parse(this.options, this.arguments);
        } catch (ParseException e) {
            log.info("Invalid values ​​for parse... \n\tFor help, type -h or --help");
        }
    }

    private Options optionsBuild() {
        options = new Options();

        this.options.addOption(Option.builder("h")
                .longOpt("help")
                .hasArg(false)
                .desc("Print this message")
                .required(false)
                .build());

        this.options.addOption(Option.builder("F")
                .longOpt("forecast")
                .argName(" \"yyyy-MM-dd HH:mm:ss\" ")
                .hasArg(true)
                .optionalArg(true)
                .desc("Set this to view the forecast *no parameter will display available dates and forecast times")
                .required(false)
                .build());

        this.options.addOption(Option.builder("c")
                .longOpt("city")
                .argName(" name ")
                .hasArg(true)
                .desc("Enter the city name")
                .required(false)
                .build());

        this.options.addOption(Option.builder("g")
                .longOpt("geo")
                .argName(" latitude longitude ")
                .hasArg(true)
                .numberOfArgs(2)
                .desc("Search by geographic coordinates")
                .required(false)
                .build());

        return options;
    }

    public void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.setWidth(120);
        formatter.setOptionComparator(new Comparator<Option>() {
            @Override
            public int compare(Option opt1, Option opt2) {
                return opt1.getOpt().compareTo(opt2.getOpt());
            }
        });
        formatter.printHelp("Options ", optionsBuild(), true);
    }

    public String optionBuildQuery() throws MissingArgumentException {

        if (cmd.hasOption("F")) {
            this.dataTime = cmd.getOptionValue("F");
            this.isForecast = true;
        }

        if (cmd.hasOption("c")) {
            StringBuilder stringBuilder = new StringBuilder(cmd.getOptionValue("c"));
            for (String arg : cmd.getArgList()) {
                stringBuilder.append("+").append(arg);
            }
            return new QueryUrlBuilder(isForecast).buildQueryByNameCity(stringBuilder.toString());
        }

        if (cmd.hasOption("g")) {
            List<String> values = Arrays.asList(cmd.getOptionValues("g"));
            return new QueryUrlBuilder(isForecast).buildQueryByCoord(values.get(0), values.get(1));
        }

        throw new MissingArgumentException("Missing argument ");
    }
}
