package com.whx.bus.common;

import java.io.Serializable;

/**
 * 用于处理datatable传递参数
 */
public class PageInfomation  implements Serializable {
    private String sEcho;

    private String iDisplayStart;

    private String iDisplayLength;

    private int startRow;

    private int rowCount;

    private int totalCount;

    public PageInfomation() {
    }

    public PageInfomation(String sEcho, String iDisplayStart, String iDisplayLength, int startRow, int rowCount, int totalCount) {
        this.sEcho = sEcho;
        this.iDisplayStart = iDisplayStart;
        this.iDisplayLength = iDisplayLength;
        this.startRow = startRow;
        this.rowCount = rowCount;
        this.totalCount = totalCount;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public String getiDisplayStart() {
        return iDisplayStart;
    }

    public void setiDisplayStart(String iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public String getiDisplayLength() {
        return iDisplayLength;
    }

    public void setiDisplayLength(String iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
