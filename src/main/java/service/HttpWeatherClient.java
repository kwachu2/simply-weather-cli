package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import model.Response;
import org.apache.commons.cli.MissingArgumentException;

import java.io.IOException;

@Slf4j
public class HttpWeatherClient {

    private final OptionCli optionCli;

    public HttpWeatherClient(OptionCli optionCli) {
        this.optionCli = optionCli;
    }

    public Response getWeather() {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        HttpResponse<JsonNode> httpResponse = null;
        try {
            httpResponse = Unirest.get(optionCli.optionBuildQuery()).asJson();
            Response response = mapper.readValue(httpResponse.getRawBody(), Response.class);
            return response;
        } catch (IOException | UnirestException | MissingArgumentException e) {
            log.info("Invalid or incomplete parameters. \n\tFor help, type -h or --help");
        }
        throw new NullPointerException();
    }
}
