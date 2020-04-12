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
    private String[] arguments;
    private String dataTime;
    private CommandLineParser parser;
    private Options options;
    private CommandLine cmd;

    public OptionCli(String[] arguments) {
        this.arguments = arguments;
        this.parser = new DefaultParser();
        this.options = optionsBuild();
        try {
            this.cmd = parser.parse(this.options, this.arguments);
        } catch (ParseException e) {
            log.info("Invalid values ​​for parse... \n\tFor help, type -h or --help");
        }
    }

    private Options optionsBuild() {
        this.options = new Options();

        this.options.addOption(Option.builder("h")
                .longOpt("help")
                .hasArg(false)
                .desc("Print this message")
                .required(false)
                .build());

        this.options.addOption(Option.builder("C")
                .longOpt("current")
                .hasArg(false)
                .desc("Set this to view the current weather")
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

        return this.options;
    }

    public void helpBuild() {
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

    public String optionBuildQuery() {
        //Current
        if (cmd.hasOption("C") && cmd.hasOption("c")) {
            StringBuilder stringBuilder = new StringBuilder(cmd.getOptionValue("c"));
            for (String arg : cmd.getArgList()) {
                stringBuilder.append("+").append(arg);
            }
            return new QueryUrlFactory("C").buildQueryByNameCity(stringBuilder.toString());
        }

        if (cmd.hasOption("C") && cmd.hasOption("g")) {
            List<String> values = Arrays.asList(cmd.getOptionValues("g"));
            return new QueryUrlFactory("C").buildQueryByCoord(values.get(0), values.get(1));
        }

        //Forecast
        if (cmd.hasOption("F") && cmd.hasOption("c")) {
            this.dataTime = cmd.getOptionValue("F");
            StringBuilder stringBuilder = new StringBuilder(cmd.getOptionValue("c"));
            for (String arg : cmd.getArgList()) {
                stringBuilder.append("+").append(arg);
            }
            return new QueryUrlFactory("F").buildQueryByNameCity(stringBuilder.toString());
        }

        if (cmd.hasOption("F") && cmd.hasOption("g")) {
            this.dataTime = cmd.getOptionValue("F");
            List<String> values = Arrays.asList(cmd.getOptionValues("g"));
            return new QueryUrlFactory("F").buildQueryByCoord(values.get(0), values.get(1));
        }
        return Arrays.toString(this.arguments);
    }
}
