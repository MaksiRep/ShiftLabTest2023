package ru.maksiRep.shift.service;


import ru.maksiRep.shift.exceptions.EmptyIntervalException;
import ru.maksiRep.shift.exceptions.IncorrectIntervalValue;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class IntervalService <T extends Comparable<T>> {
    protected ArrayList<ArrayList<T>> find(ArrayList<ArrayList<T>> intervalList) {

        ArrayList<ArrayList<T>> resultArray = new ArrayList<>();
        intervalList.sort(Comparator.comparing(interval -> interval.get(0)));
        int length = intervalList.size();
        int leftValue = 0;
        int rightValue = 1;

        if (length == 1) {
            resultArray.add(intervalList.get(0));
        } else {
            for (int i = 1; i < length; i++) {
                ArrayList<T> previous = intervalList.get(i - 1);
                ArrayList<T> next = intervalList.get(i);
                if (next.get(leftValue).compareTo(previous.get(rightValue)) <= 0) {
                    if (next.get(rightValue).compareTo(previous.get(rightValue)) <= 0)
                        next.set(rightValue, previous.get(rightValue));
                    next.set(leftValue, previous.get(leftValue));
                } else {
                    resultArray.add(new ArrayList<>(previous));
                }
                if (i == length - 1)
                    resultArray.add(new ArrayList<>(next));
            }
        }

        return resultArray;
    }

    public abstract void addInterval(ArrayList<ArrayList<T>> intervalList) throws EmptyIntervalException, IncorrectIntervalValue;

    public abstract ArrayList<T> getInterval() throws EmptyIntervalException;

}
