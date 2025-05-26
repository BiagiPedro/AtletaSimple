package com.Biagi.atletasimple.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public String status() {
        return "API está rodando na porta 8080!";
    }
}
