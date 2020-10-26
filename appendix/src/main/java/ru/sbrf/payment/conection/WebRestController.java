package ru.sbrf.payment.conection;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.client.User;

import java.util.ArrayList;

@RestController
@RequestMapping("/servers/{serverId}/{identifier}")
@AllArgsConstructor
public class WebRestController {
    private WebServerConnector service;

    @RequestMapping(method = RequestMethod.POST,
            value = "/pay")
    String pay(@PathVariable("serverId") Long serverId,
               @PathVariable("identifier") Long identifier,
               @RequestBody PaymentParameters parameters) {

        return parameters.getResult();
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/getCountsList")
    ArrayList<Counts> getCountsList(@PathVariable("serverId") Long serverId,
                                    @PathVariable("identifier") Long identifier,
                                    @RequestBody User user) {
        user = user.getUserWithoutCounts();

        return user.getClientCountsList();
    }
}
