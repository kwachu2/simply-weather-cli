package service;

import lombok.extern.slf4j.Slf4j;
import setup.PermanentSetup;
import setup.QueryProperties;

import static setup.PermanentSetup.*;

@Slf4j
public class QueryUrlBuilder {

    private final QueryProperties queryProperties;
    private PermanentSetup prefix;

    public QueryUrlBuilder(String prefix) {
        this.queryProperties = new QueryProperties();
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
                .append(queryProperties.getQueryApiKey())
                .append(AND)
                .append(queryProperties.getQueryUnits())
                .append(AND)
                .append(queryProperties.getQueryLanguage())
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

