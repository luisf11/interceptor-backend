package com.akatsukilab.xmpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@Service
public class OpenFireRestClient {

    private RestTemplate restTemplate = new RestTemplate();
    private String SERVER_URL = "http://54.91.199.178:9090/plugins/restapi/v1/";
    // private String SERVER_URL = "http://localhost:9090/plugins/restapi/v1/";
    // private String SECRET_KEY = "FKLX50AxPX0uHj5b";
    private String SECRET_KEY = "AXtyOWOV1PIMkPl9";

    public <T> T getEntitie(String url, Class<T> responseClass){
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", SECRET_KEY);
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<String>("",headers);

ResponseEntity<T> response = restTemplate.exchange(SERVER_URL+url, HttpMethod.GET, requestEntity, responseClass); 

        
        return response.getBody();
    }
    
}
