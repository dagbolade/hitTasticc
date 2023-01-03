/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class ViewOrdersTestClient {
    public static void main(String[] args) {
        // create a client
        Client client = ClientBuilder.newClient();

        // create a web target for the API
        WebTarget target = client.target("http://localhost:8080/hitTasticc/order.jsp")
            .resolveTemplate("id", "2");

        // send a GET request to the API
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        // print the response status and the response body
        System.out.println("Response status: " + response.getStatus());
        System.out.println("Response body: " + response.readEntity(String.class));
    }
}
