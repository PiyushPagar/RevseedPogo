package com.revnomix.revseed.wrapper.dashboard;

import java.io.Serializable;
import java.util.List;
 
public class JQGridDTO <T> {
 
    private int page;
 
    private String total;
 
    private String rows;
 
    private List<T> records;
 
    public int getPage() {
        return page;
    }
 
    public void setPage(int page) {
        this.page = page;
    }
 
    public String getTotal() {
        return total;
    }
 
    public void setTotal(String total) {
        this.total = total;
    }
 
    public List<T>  getRecords() {
        return records;
    }
 
    public void setRecords(List<T>  records) {
        this.records = records;
    }
 
    public String getRows() {
        return rows;
    }
 
    public void setRows(String rows) {
        this.rows = rows;
    }
 
}