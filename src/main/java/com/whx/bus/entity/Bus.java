package com.whx.bus.entity;

import java.util.Date;

public class Bus {
    private Integer id;

    private String card;

    private Integer driverid;

    private Integer wayid;

    private Double price;

    private Date topen;

    private Date tclose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public Integer getDriverid() {
        return driverid;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    public Integer getWayid() {
        return wayid;
    }

    public void setWayid(Integer wayid) {
        this.wayid = wayid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTopen() {
        return topen;
    }

    public void setTopen(Date topen) {
        this.topen = topen;
    }

    public Date getTclose() {
        return tclose;
    }

    public void setTclose(Date tclose) {
        this.tclose = tclose;
    }
}