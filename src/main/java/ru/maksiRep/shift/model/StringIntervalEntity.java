package ru.maksiRep.shift.model;

import javax.persistence.*;

@Entity
@Table(name = "STRING_INTERVAL")
public class StringIntervalEntity {

    public StringIntervalEntity() {
    }

    public StringIntervalEntity(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "ID")
    private Integer id;

    @Column (name = "START_INTERVAL")
    private String start;
    @Column (name = "END_INTERVAL")
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
