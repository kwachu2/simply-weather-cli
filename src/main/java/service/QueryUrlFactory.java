package service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import setup.PermanentSetup;
import setup.QuerySetup;

import java.io.File;
import java.io.IOException;

import static setup.PermanentSetup.*;

@Slf4j
@Data
public class QueryUrlFactory {

    File configFile = new File("querySetup.properties");
    QuerySetup querySetup;                                   //exception
    PermanentSetup prefix;
    StringBuilder stringBuilder = new StringBuilder(BASE_URL.toString());


    public QueryUrlFactory(String prefix) {
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

    String buildQueryByNameCity(String optionValue) {
        stringBuilder
                .append(prefix)
                .append(QUESTION_MARK)
                .append(PREFIX_CITY_NAME)
                .append(optionValue)
                .append(AND)
                .append(querySetup.getQueryApiKey())
                .append(AND)
                .append(querySetup.getQueryUnits())
                .append(AND)
                .append(querySetup.getQueryLanguage());
        return stringBuilder.toString();
    }

    String buildQueryByCoord(String lat, String lon) {
        stringBuilder
                .append(prefix)
                .append(QUESTION_MARK)
                .append(PREFIX_LATITUDE).append(lat)
                .append(AND)
                .append(PREFIX_LONGITUDE).append(lon)
                .append(AND)
                .append(querySetup.getQueryApiKey())
                .append(AND)
                .append(querySetup.getQueryUnits())
                .append(AND)
                .append(querySetup.getQueryLanguage());
        return stringBuilder.toString();
    }
}

