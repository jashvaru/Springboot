package com.jash.SpringWebAppAWS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greeting() {
        return "Hello AWS";
    }

    @GetMapping("/info")
    public String systemInfo() {
        String os = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String architecture = System.getProperty("os.arch");

        return String.format("OS: %s, Java Version: %s, Architecture: %s", os, javaVersion, architecture);
    }

}
