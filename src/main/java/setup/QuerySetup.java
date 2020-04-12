package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static setup.PermanentSetup.*;

public class QuerySetup {

    private FileInputStream fileInputStream;
    private Properties properties;

    private String apiKey = "4f1db7ab46d3b2fbc8c3c383dfee370c"; //default developer api key
    private String language = "en";                             //default language
    private String units = "metric";                            //default units format as metric

    public QuerySetup() {
    }

    public QuerySetup(File configFile) throws IOException {
        this.fileInputStream = new FileInputStream(configFile);
        this.properties = new Properties();
        properties.load(fileInputStream);
        this.apiKey = this.properties.getProperty("apiKey");
        this.language = this.properties.getProperty("language");
        this.units = this.properties.getProperty("units");
        this.fileInputStream.close();
    }

    public String getQueryApiKey() {
        return PREFIX_API_KEY + apiKey;
    }

    public String getQueryLanguage() {
        return PREFIX_LANGUAGE + language;
    }

    public String getQueryUnits() {
        return PREFIX_UNIT_FORMAT + units;
    }
}
