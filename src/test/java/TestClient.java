/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */
import com.assessment.hittasticc.model.Song;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class TestClient {
    public static void main(String[] args) {
        String searchInput = "song";

        ArrayList<Song> songs = new ArrayList<Song>();

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/hitTasticc/search-results.jsp")
                                .queryParam("q", searchInput);
        Response response = target.request().get();

        int status = response.getStatus();
        if (status == 200) {
            // Success!
            String data = response.readEntity(String.class);
            // Parse the JSON data and add each song to the list
            // ...
            System.out.println("Expected Songs: " + songs);
        } else {
            // An error occurred
            System.out.println("An error occurred: " + status);
        }
    }
}

