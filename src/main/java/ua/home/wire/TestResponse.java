package ua.home.wire;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpHeaders;
import ua.home.entity.Test;
import ua.home.service.TestService;

public class TestResponse {


    private HttpHeaders responseHeaders;
    private String json;

    public TestResponse(Test testService) {
        responseHeaders = new HttpHeaders();
        convert(testService);
    }

    private void convert(Test testService) {

        responseHeaders.add("Content-Type", "application/json;charset=UTF-8");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        try {
            json = ow.writeValueAsString(testService);
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


