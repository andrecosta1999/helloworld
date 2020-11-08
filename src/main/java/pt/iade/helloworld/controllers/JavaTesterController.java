package pt.iade.helloworld.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path="/api/java/tester")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class);
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor() {
        logger.info("Get Information");
        String name = "André Costa";
        int number = 20190933;
        double height = 1.75;
        boolean isFan = true;
        String club = "Benfica";

        if (isFan) {
            return "Done by " + name + " with number " + number + ".\n" + "I am " + height + " tall and I am a fan of footbal." + "\n" + "My favourite club is " + club+".";
        } else if (!isFan) {
            return "Done by " + name + " with number " + number + ".\n" + "I am " + height + " tall and not a fan of football.";
        } else{
            return "No information gathered";
        }
    }
    @GetMapping(path ="/access/{student}/{covid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent, @PathVariable("covid") boolean hasCovid) {
        if (isStudent && (!hasCovid)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping(path ="/required/{student}/{temperature}/{classType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent, @PathVariable("temperature") double hasCovid, @PathVariable("classType") String type) {
        if (isStudent && type.equals("presential") && (hasCovid < 37.5 && hasCovid > 34.5)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping(path ="/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getEvacuation(@PathVariable("fire") boolean isfire, @PathVariable("numberOfCovids") int numberOfCovids, @PathVariable("powerShutdown") boolean ispowerShutdown, @PathVariable("comeBackTime") int comeBackTime) {
        if (isfire) {
            return true;
        } else if (numberOfCovids > 5) {
            return true;
        } else if (ispowerShutdown && comeBackTime > 15) {
            return true;
        }
        return false;
    }
    
    private double grades[] = { 10.5, 12, 14.5 };
    
    @GetMapping(path ="/average", produces = MediaType.APPLICATION_JSON_VALUE)
    public double average() {
        double total = 0;
        for (int i = 0; i < grades.length; i++) {
            total = total + grades[i];
        }
        double average = total / (double) grades.length;
        return average;
    }

    @GetMapping(path ="/maxgrade", produces = MediaType.APPLICATION_JSON_VALUE)
    public double maxGrade() {
        double max = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    private String ucs[] = { "FP", "POO", "BD" };

    @GetMapping(path ="/ucgrade", produces = MediaType.APPLICATION_JSON_VALUE)
    public double ucGrade() {
        String uc = "POO";
        double ucgrade = 0;
        for (int i = 1; i < ucs.length; i++) {
            if (ucs[i].equals(uc)) {
                ucgrade = grades[i];
            }
        }
        return ucgrade;
    }

    @GetMapping(path ="/minmaxgrade", produces = MediaType.APPLICATION_JSON_VALUE)
    public double minmaxGrade() {
        double min = 9.5;
        double max = 20;
        double ucgradelimits = 0;
        for (int i = 1; i < ucs.length; i++) {
            if (grades[i] >= min && (grades[i] <= max)) {
                ucgradelimits++;
            }
        }
        return ucgradelimits;
    }

    @GetMapping(path ="/text", produces = MediaType.APPLICATION_JSON_VALUE)
    public String text() {
        String text = "";
        for (int i = 1; i < ucs.length; i++) {
            text = text + ucs[i] + " " + grades[i] + " ";
        }
        return text;
    }
}

