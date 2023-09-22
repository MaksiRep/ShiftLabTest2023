package ru.maksiRep.shift.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class IntervalRequest {

    @JsonProperty(value = "array")
    private ArrayList<ArrayList<String>> intervalList;

    public ArrayList<ArrayList<String>> getIntervalList() {
        return intervalList;
    }

    public void setIntervalList(ArrayList<ArrayList<String>> intervalList) {
        this.intervalList = intervalList;
    }

}
