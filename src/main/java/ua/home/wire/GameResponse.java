package ua.home.wire;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpHeaders;
import ua.home.service.GameService;

public class GameResponse {

    private HttpHeaders responseHeaders;
    private String json;

    public GameResponse(GameService gameService) {
        responseHeaders = new HttpHeaders();
        convert(gameService);
    }

    private void convert(GameService gameService) {

        responseHeaders.add("Content-Type", "application/json;charset=UTF-8");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        try {
            json = ow.writeValueAsString(gameService);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public HttpHeaders getResponseHeaders() {
        return responseHeaders;
    }

    public String getJson() {
        return json;
    }
}
