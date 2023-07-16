package ehtp.mostafa.webhookservice.controller;

import ehtp.mostafa.webhookservice.service.SlackService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slack/v1")
public class SlackController {
    @Autowired
    private SlackService slackService ;

    @PostMapping(path = "/sendMessage")
    public String send(@RequestBody String message ) {
       try  {
           System.out.println(message);
           slackService.sendMessageToSlack(message) ;
           return "message send  Successfully...";
       } catch (Exception e){
           return "Echoue to send message !! " ;
       }

    }
}