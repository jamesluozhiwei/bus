package com.whx.bus.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties
public class History implements Serializable {
    private Integer id;

    private Integer busid;

    private Integer wayid;

    private Integer driverid;

    private Integer state;

    private Date tgo;

    private Date tend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public Integer getWayid() {
        return wayid;
    }

    public void setWayid(Integer wayid) {
        this.wayid = wayid;
    }

    public Integer getDriverid() {
        return driverid;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTgo() {
        return tgo;
    }

    public void setTgo(Date tgo) {
        this.tgo = tgo;
    }

    public Date getTend() {
        return tend;
    }

    public void setTend(Date tend) {
        this.tend = tend;
    }
}