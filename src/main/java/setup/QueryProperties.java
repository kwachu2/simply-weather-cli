package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QueryProperties {

    private static final String DEFAULT_API_KEY = "4f1db7ab46d3b2fbc8c3c383dfee370c";
    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DEFAULT_UNITS = "metric";
    private final String PREFIX_API_KEY = "appid=";
    private final String PREFIX_LANGUAGE = "lang=";
    private final String PREFIX_UNIT_FORMAT = "units=";
    private final File configFile = new File("querySetup.properties");
    private String apiKey;
    private String language;
    private String units;

    public QueryProperties() {
        Properties properties;
        try {
            properties = loadProperties(this.configFile);
            this.apiKey = properties.getProperty("apiKey");
            this.language = properties.getProperty("language");
            this.units = properties.getProperty("units");
        } catch (IOException e) {
            this.apiKey = DEFAULT_API_KEY;
            this.language = DEFAULT_LANGUAGE;
            this.units = DEFAULT_UNITS;
        }
    }

    Properties loadProperties(File configFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(configFile);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
        return properties;

    }

    public String getQueryApiKey() {
        return this.PREFIX_API_KEY + apiKey;
    }

    public String getQueryLanguage() {
        return this.PREFIX_LANGUAGE + language;
    }

    public String getQueryUnits() {
        return this.PREFIX_UNIT_FORMAT + units;
    }
}
