package ru.maksiRep.shift.model;

import javax.persistence.*;

@Entity
@Table (name = "INTEGER_INTERVAL")
public class IntegerIntervalEntity {

    public IntegerIntervalEntity() {
    }

    public IntegerIntervalEntity(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "ID")
    private Integer id;

    @Column (name = "START_INTERVAL")
    private Integer start;
    @Column (name = "END_INTERVAL")
    private Integer end;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
