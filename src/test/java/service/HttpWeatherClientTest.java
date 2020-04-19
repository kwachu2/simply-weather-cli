package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.tomakehurst.wiremock.WireMockServer;
import model.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class HttpWeatherClientTest {

    private final WireMockServer mockedServer = new WireMockServer();

    @BeforeAll
    public void startServer() {

        mockedServer.start();

    }

    @AfterAll
    public void stopServer() {

        mockedServer.stop();

    }

    Response loadTestFileAndPrepareResponse(String pathFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(pathFile);
        FileReader reader = new FileReader(file);
        Response response = mapper.readValue(reader, Response.class);
        reader.close();
        return response;
    }


    @Test
    void getWeatherTestCurrent() throws IOException {

        // given
        String testUrl = "/data/2.5/weather?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&q=warsaw";

        stubFor(get(urlEqualTo(testUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("testCurrentResponseBody.json")));

        String testQueryUrl = "http://localhost:8080" + testUrl;

        Response localResponse = loadTestFileAndPrepareResponse("src/test/resources/__files/testCurrentResponseBody.json");

        //when
        HttpWeatherClient httpWeatherClientTest = new HttpWeatherClient(testQueryUrl);

        //then
        assertEquals(localResponse, httpWeatherClientTest.getWeather());

    }

    @Test
    void getWeatherTestForecast() throws IOException {

        // given
        String testUrl = "/data/2.5/forecast?appid=4f1db7ab46d3b2fbc8c3c383dfee370c&units=metric&lang=pl&q=warsaw";

        stubFor(get(urlEqualTo(testUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("testForecastResponseBody.json")));

        String testQueryUrl = "http://localhost:8080" + testUrl;

        Response localResponse = loadTestFileAndPrepareResponse("src/test/resources/__files/testForecastResponseBody.json");

        //when
        HttpWeatherClient httpWeatherClientTest = new HttpWeatherClient(testQueryUrl);
        Response responseFromHttpWeatherClientTest = httpWeatherClientTest.getWeather();

        //then
        assertEquals(localResponse, responseFromHttpWeatherClientTest);

    }

    @Test()
    void getWeatherTestInvalidUrlException() {

        // given
        String testUrl = "test...invalid url...test";
        String expectedMessage = "no protocol: test...invalid url...test";

        //when
        HttpWeatherClient httpWeatherClientTest = new HttpWeatherClient(testUrl);
        Exception exception = assertThrows(RuntimeException.class, () -> httpWeatherClientTest.getWeather());

        String actualMessage = exception.getMessage();

        //then
        assertTrue(actualMessage.contains(expectedMessage));

    }

}