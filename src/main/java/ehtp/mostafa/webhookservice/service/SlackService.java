package ehtp.mostafa.webhookservice.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class SlackService {
    private final RestTemplate restTemplate ;
    @Value(value = "${hook.slack.url}")
    private String url ;

    public SlackService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendMessageToSlack(String message)throws Exception{

        Map<String , String> messageBuilder = new HashMap<String , String>();
        HttpHeaders headers =  new HttpHeaders();
        // set the headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        messageBuilder.put("text" , message) ;
        HttpEntity<Map<String , String >> request = new HttpEntity<>(messageBuilder , headers);
        restTemplate.postForEntity(url , request , String.class ) ;

    }
}
