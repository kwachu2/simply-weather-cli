package service;

import lombok.extern.slf4j.Slf4j;
import setup.PermanentSetup;
import setup.QuerySetup;

import java.io.File;
import java.io.IOException;

import static setup.PermanentSetup.*;

@Slf4j
public class QueryUrlBuilder {

    private final File configFile = new File("querySetup.properties");
    private QuerySetup querySetup;
    private PermanentSetup prefix;


    public QueryUrlBuilder(String prefix) {
        try {
            this.querySetup = new QuerySetup(configFile);
        } catch (IOException e) {
            this.querySetup = new QuerySetup();
        }
        if (prefix.equals("C")) {
            this.prefix = PREFIX_CURRENT_WEATHER;
        } else if (prefix.equals("F")) {
            this.prefix = PREFIX_FORECAST_WEATHER;
        }
    }

    StringBuilder queryBase() {
        return new StringBuilder(String.valueOf(BASE_URL))
                .append(prefix)
                .append(QUESTION_MARK)
                .append(querySetup.getQueryApiKey())
                .append(AND)
                .append(querySetup.getQueryUnits())
                .append(AND)
                .append(querySetup.getQueryLanguage())
                .append(AND);
    }

    String buildQueryByNameCity(String optionValue) {
        return queryBase()
                .append(PREFIX_CITY_NAME)
                .append(optionValue)
                .toString();
    }

    String buildQueryByCoord(String lat, String lon) {
        return queryBase()
                .append(PREFIX_LATITUDE).append(lat)
                .append(AND)
                .append(PREFIX_LONGITUDE).append(lon)
                .toString();
    }
}

