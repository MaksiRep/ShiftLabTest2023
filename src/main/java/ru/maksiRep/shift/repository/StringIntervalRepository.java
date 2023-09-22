package ru.maksiRep.shift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.maksiRep.shift.model.StringIntervalEntity;

@Repository
public interface StringIntervalRepository extends JpaRepository <StringIntervalEntity, Integer> {

    @Query(value = "SELECT *\n" +
                    "FROM STRING_INTERVAL\n" +
                    "WHERE START_INTERVAL = (SELECT MIN(START_INTERVAL)\n" +
                    "                            FROM STRING_INTERVAL)\n" +
                    "AND  END_INTERVAL = (SELECT MIN(END_INTERVAL)\n" +
                    "                            FROM STRING_INTERVAL)\n" +
                    "AND ROWNUM = 1;", nativeQuery = true)
    StringIntervalEntity getMin();
}
