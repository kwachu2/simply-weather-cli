package service;

import lombok.extern.slf4j.Slf4j;
import setup.QueryProperties;

@Slf4j
public class QueryUrlBuilder {

    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private final String PREFIX_CURRENT_WEATHER = "weather";
    private final String PREFIX_FORECAST_WEATHER = "forecast";
    private final String PREFIX_CITY_NAME = "q=";
    private final String PREFIX_LATITUDE = "lat=";
    private final String PREFIX_LONGITUDE = "lon=";
    private final String QUESTION_MARK = "?";
    private final String AND = "&";
    private final QueryProperties queryProperties;
    private String prefix;

    public QueryUrlBuilder(boolean isForecast) {
        this.queryProperties = new QueryProperties();
        if (isForecast) {
            this.prefix = this.PREFIX_FORECAST_WEATHER;
        } else {
            this.prefix = this.PREFIX_CURRENT_WEATHER;
        }
    }

    StringBuilder queryBase() {
        return new StringBuilder(this.BASE_URL)
                .append(this.prefix)
                .append(this.QUESTION_MARK)
                .append(queryProperties.getQueryApiKey())
                .append(this.AND)
                .append(queryProperties.getQueryUnits())
                .append(this.AND)
                .append(queryProperties.getQueryLanguage())
                .append(this.AND);
    }

    String buildQueryByNameCity(String optionValue) {
        return queryBase()
                .append(this.PREFIX_CITY_NAME)
                .append(optionValue)
                .toString();
    }

    String buildQueryByCoord(String lat, String lon) {
        return queryBase()
                .append(this.PREFIX_LATITUDE).append(lat)
                .append(this.AND)
                .append(this.PREFIX_LONGITUDE).append(lon)
                .toString();
    }
}

