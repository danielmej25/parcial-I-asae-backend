package co.edu.unicauca.Parcial.I.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

        @GetMapping("/")
        public String healthCheck() {
                return "HEALTH CHECK OK!";
        }

        @GetMapping("/version")
        public String version() {
                return "The actual version is 1.0.0";
        }

}