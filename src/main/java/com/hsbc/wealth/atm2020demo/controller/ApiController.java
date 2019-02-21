package com.hsbc.wealth.atm2020demo.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Random;


@RestController
public class ApiController {

    private boolean requestSubmitted = false;
    private long authCode;

    @GetMapping(value="/check")
    public String checkIfRequestSubmited() {
        return "<ret>" + requestSubmitted + "</ret>";
    }

    @GetMapping(value="/request")
    public String submitRequest() {
        requestSubmitted = true;
        return "<ret>true</ret>";
    }

    @GetMapping(value="/genauth")
    public String genAuthCode() {
        if (authCode == 0) {
            Random r = new Random();
            int low = 100000;
            int high = 999999;
            authCode = r.nextInt(high-low) + low;
        }
        return "<ret>" + authCode + "</ret>";
    }
}
