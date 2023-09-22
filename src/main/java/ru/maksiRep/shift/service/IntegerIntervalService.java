package ru.maksiRep.shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksiRep.shift.exceptions.EmptyIntervalException;
import ru.maksiRep.shift.model.IntegerIntervalEntity;
import ru.maksiRep.shift.repository.IntegerIntervalRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntegerIntervalService extends IntervalService<Integer> {

    @Autowired
    private IntegerIntervalRepository integerIntervalRepository;

    @Override
    public void addInterval(ArrayList<ArrayList<Integer>> intervalList) throws EmptyIntervalException {
        if (intervalList.isEmpty())
            throw new EmptyIntervalException("Interval is empty");
        var resultIntervals = find(intervalList);
        for (List<Integer> interval : resultIntervals) {
            IntegerIntervalEntity entity = new IntegerIntervalEntity(interval.get(0), interval.get(1));
            integerIntervalRepository.save(entity);
        }
    }

    @Override
    public ArrayList<Integer> getInterval() throws EmptyIntervalException {
        ArrayList<Integer> minInterval = new ArrayList<>();
        IntegerIntervalEntity integerIntervalEntity = integerIntervalRepository.getMin();
        if (integerIntervalEntity == null) {
            throw new EmptyIntervalException("Can't find interval");
        }
        minInterval.add(integerIntervalEntity.getStart());
        minInterval.add(integerIntervalEntity.getEnd());
        return minInterval;
    }
}
