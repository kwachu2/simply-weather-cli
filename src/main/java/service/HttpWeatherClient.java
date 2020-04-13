package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import model.Response;

import java.io.IOException;

@Slf4j
public class HttpWeatherClient {

    private final OptionCli optionCli;

    public HttpWeatherClient(OptionCli optionCli) {
        this.optionCli = optionCli;
    }

    public Response getWeather() {

        String queryUrl = optionCli.optionBuildQuery();
        System.out.println(queryUrl);
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        HttpResponse<JsonNode> httpResponse = null;
        try {
            httpResponse = Unirest.get(queryUrl).asJson();
        } catch (UnirestException e) {
            log.info("\tInvalid or incomplete parameters. \n\tFor help, type -h or --help", e.getMessage());
        }
        Response response = null;
        try {
            response = mapper.readValue(httpResponse.getRawBody(), Response.class);
        } catch (IOException | NullPointerException e) {
            log.info("\tInvalid or incomplete parameters. \n\tFor help, type -h or --help", e.getMessage());
        }
        return response;
    }


}
