package com.zacharadamian.fibonacciapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class HistoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Long parameter;
    private Long result;

    public HistoryEntry(String date, Long parameter, Long result) {
        this.date = date;
        this.parameter = parameter;
        this.result = result;
    }

    public HistoryEntry() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getParameter() { return parameter;}

    public void setParameter(Long parameter) { this.parameter = parameter; }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}

