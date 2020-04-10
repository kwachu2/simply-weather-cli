package setup;

import lombok.Data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static setup.PermanentSetup.*;

@Data
public class QuerySetup {

    private FileReader fileReader;
    private Properties properties;

    private String apiKey = "4f1db7ab46d3b2fbc8c3c383dfee370c"; //default developer api key
    private String language = "en";                             //default language
    private String units = "metric";                            //default units format as metric

    public QuerySetup() {
    }

    public QuerySetup(File configFile) throws IOException {
        this.fileReader = new FileReader(configFile);
        this.properties = new Properties();
        properties.load(fileReader);
        this.apiKey = this.properties.getProperty("apiKey");
        this.language = this.properties.getProperty("language");
        this.units = this.properties.getProperty("units");
        this.fileReader.close();
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
