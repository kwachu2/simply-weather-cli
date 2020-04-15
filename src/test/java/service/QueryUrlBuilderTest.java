package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryUrlBuilderTest {

    @Test
    void queryBaseCurrent() {

        //given
        String expectedUrl = "https://api.openweathermap.org/data/2.5/weather?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&";
        QueryUrlBuilder queryUrlBuilder = new QueryUrlBuilder(false);

        //when
        String queryBuilderExpectedToString = queryUrlBuilder.queryBase().toString();

        //then
        assertEquals(expectedUrl, queryBuilderExpectedToString);
    }

    @Test
    void buildQueryByNameCityCurrent() {

        //given
        String expectedUrl = "https://api.openweathermap.org/data/2.5/weather?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&q=warsaw";
        QueryUrlBuilder queryUrlBuilder = new QueryUrlBuilder(false);

        //when
        String actualQueryBuilderUrl = queryUrlBuilder.buildQueryByNameCity("warsaw");

        //then
        assertEquals(expectedUrl, actualQueryBuilderUrl);
    }

    @Test
    void buildQueryByCoordCurrent() {

        //given
        String expectedUrl = "https://api.openweathermap.org/data/2.5/weather?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&lat=52.23&lon=21.01";
        QueryUrlBuilder queryUrlBuilder = new QueryUrlBuilder(false);

        //when
        String actualQueryBuilderUrl = queryUrlBuilder.buildQueryByCoord("52.23", "21.01");

        //then
        assertEquals(expectedUrl, actualQueryBuilderUrl);
    }

    @Test
    void queryBaseForecast() {

        //given
        String expectedUrl = "https://api.openweathermap.org/data/2.5/forecast?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&";
        QueryUrlBuilder queryUrlBuilder = new QueryUrlBuilder(true);

        //when
        String queryBuilderExpectedToString = queryUrlBuilder.queryBase().toString();

        //then
        assertEquals(expectedUrl, queryBuilderExpectedToString);
    }

    @Test
    void buildQueryByNameCityForecast() {

        //given
        String expectedUrl = "https://api.openweathermap.org/data/2.5/forecast?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&q=warsaw";
        QueryUrlBuilder queryUrlBuilder = new QueryUrlBuilder(true);

        //when
        String actualQueryBuilderUrl = queryUrlBuilder.buildQueryByNameCity("warsaw");

        //then
        assertEquals(expectedUrl, actualQueryBuilderUrl);
    }

    @Test
    void buildQueryByCoordForecast() {

        //given
        String expectedUrl = "https://api.openweathermap.org/data/2.5/forecast?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&lat=52.23&lon=21.01";
        QueryUrlBuilder queryUrlBuilder = new QueryUrlBuilder(true);

        //when
        String actualQueryBuilderUrl = queryUrlBuilder.buildQueryByCoord("52.23", "21.01");

        //then
        assertEquals(expectedUrl, actualQueryBuilderUrl);
    }
}