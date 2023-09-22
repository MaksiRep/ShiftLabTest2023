package ru.maksiRep.shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksiRep.shift.exceptions.EmptyIntervalException;
import ru.maksiRep.shift.exceptions.IncorrectIntervalValue;
import ru.maksiRep.shift.model.StringIntervalEntity;
import ru.maksiRep.shift.repository.StringIntervalRepository;

import java.util.ArrayList;

@Service
public class StringIntervalService extends IntervalService<String> {

    @Autowired
    private StringIntervalRepository stringIntervalRepository;

    @Override
    public void addInterval(ArrayList<ArrayList<String>> intervalList) throws EmptyIntervalException, IncorrectIntervalValue {
        if (intervalList.isEmpty())
            throw new EmptyIntervalException("Interval is empty");
        var resultIntervals = find(intervalList);
        for (ArrayList<String> interval : resultIntervals) {
            StringIntervalEntity entity = new StringIntervalEntity(interval.get(0), interval.get(1));
            stringIntervalRepository.save(entity);
        }
    }

    @Override
    public ArrayList<String> getInterval() throws EmptyIntervalException {
        ArrayList<String> minInterval = new ArrayList<>();
        StringIntervalEntity stringIntervalEntity = stringIntervalRepository.getMin();
        if (stringIntervalEntity == null) {
            throw new EmptyIntervalException("Can't find interval");
        }
        minInterval.add(stringIntervalEntity.getStart());
        minInterval.add(stringIntervalEntity.getEnd());
        return minInterval;
    }

}
