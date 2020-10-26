package ru.sbrf.payment.conection.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.payment.client.Counts;
import ru.sbrf.payment.client.PaymentParameters;
import ru.sbrf.payment.client.User;
import ru.sbrf.payment.conection.service.ServerHandler;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class Controller {
    private ServerHandler server;

    @GetMapping("")
    public String getServerStatus() {
        return "Server is ready.";
    }

    @PostMapping("/servers/{serverId}/{identifier}/getCountsList")
    public ArrayList<Counts> getIdByNumber(@PathVariable("serverId") Long serverId,
                                           @PathVariable("identifier") Long identifier,
                                           @RequestBody User user){


        return server.loadCountsList(identifier, user);
    }

    @PostMapping("/servers/{serverId}/{identifier}/pay")
    public String pay(@PathVariable("serverId") Long serverId,
                      @PathVariable("identifier") Long identifier,
                      @RequestBody PaymentParameters parameters) {
        String result = "обработка данных не удалась";
        server.pay(identifier, parameters, result);
        return result;
    }
}
