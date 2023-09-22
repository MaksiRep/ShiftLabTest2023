package ru.maksiRep.shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maksiRep.shift.controller.request.IntervalRequest;
import ru.maksiRep.shift.exceptions.EmptyIntervalException;
import ru.maksiRep.shift.exceptions.IncorrectIntervalValue;
import ru.maksiRep.shift.service.IntegerIntervalService;
import ru.maksiRep.shift.service.StringIntervalService;

import java.util.ArrayList;

@RestController
public class IntervalController {

    @Autowired
    private IntegerIntervalService integerIntervalService;

    @Autowired
    private StringIntervalService stringIntervalService;

    @PostMapping(value = "/api/v1/intervals/merge")
    public void addInterval(@RequestParam(value = "kind") String type,
                            @RequestBody IntervalRequest intervalRequest) throws EmptyIntervalException, IncorrectIntervalValue {
        if (type.equals("digits")) {
            int digit = 0;
            ArrayList<ArrayList<Integer>> integerIntervals = new ArrayList<>();
            for (int i = 0; i < intervalRequest.getIntervalList().size(); i++) {
                integerIntervals.add(new ArrayList<>());
                for (String value : intervalRequest.getIntervalList().get(i)) {
                    if (!Character.isDigit(value.charAt(digit)) && value.length() > 1) {
                        throw new IncorrectIntervalValue("Incorrect interval value");
                    }
                    integerIntervals.get(i).add(Integer.parseInt(value));
                }
            }
            integerIntervalService.addInterval(integerIntervals);
        } else if (type.equals("letters")) {
            int letter = 0;
            for (ArrayList<String> interval : intervalRequest.getIntervalList()) {
                for (String value : interval) {
                    if (Character.isDigit(value.charAt(letter)) && value.length() > 1) {
                        throw new IncorrectIntervalValue("Incorrect interval value");
                    }
                }
            }
            stringIntervalService.addInterval(intervalRequest.getIntervalList());
        }
    }


    @GetMapping(value = "/api/v1/intervals/min")
    public Object getInterval(@RequestParam(value = "kind") String type) throws EmptyIntervalException {
        if (type.equals("digits")) {
            return integerIntervalService.getInterval();
        } else if (type.equals("letters")) {
            return stringIntervalService.getInterval();
        }
        return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
    }
}
