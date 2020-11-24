package training.metofficeweather;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Client client = ClientBuilder.newClient();
        String name = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=873939b7-e899-4b32-8a41-0e19f704cbf3")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        Wrapper wrapper = objectMapper.readValue(name, Wrapper.class);

        Locations locations = wrapper.getLocations();
        System.out.println(locations);
    }
}