package com.whx.bus.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties
public class Way implements Serializable {
    private Integer id;

    private String name;

    private Date topen;

    private Date tclose;

    private List<Station> stations;

    private String topenString;

    private String tcloseString;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getTopen() {
        return topen;
    }

    public void setTopen(Date topen) {
        this.topen = topen;
        this.topenString = new SimpleDateFormat("HH:mm:ss").format(topen);
    }

    public Date getTclose() {
        return tclose;
    }

    public void setTclose(Date tclose) {
        this.tclose = tclose;
        this.tcloseString = new SimpleDateFormat("HH:mm:ss").format(tclose);
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public String getTopenString() {
        return topenString;
    }

    public void setTopenString(String topenString) {
        this.topenString = topenString;
    }

    public String getTcloseString() {
        return tcloseString;
    }

    public void setTcloseString(String tcloseString) {
        this.tcloseString = tcloseString;
    }
}