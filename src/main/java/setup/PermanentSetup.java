package setup;

public enum PermanentSetup {

    BASE_URL("https://api.openweathermap.org/data/2.5/"),
    PREFIX_CURRENT_WEATHER("weather"),
    PREFIX_FORECAST_WEATHER("forecast"),
    PREFIX_API_KEY("appid="),
    PREFIX_LANGUAGE("lang="),
    PREFIX_UNIT_FORMAT("units="),
    PREFIX_CITY_NAME("q="),
    PREFIX_LATITUDE("lat="),
    PREFIX_LONGITUDE("lon="),
    QUESTION_MARK("?"),
    AND("&");

    private String stringRepresentation;

    PermanentSetup(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }
}
