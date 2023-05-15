package com.revnomix.revseed.wrapper.analysis;

public class AdrByDOW {
    private String dow;
    private Integer min;
    private Integer p5;
    private Integer p95;
    private Integer max;
    private Integer avg;
    private Integer upperQuartile;
    private Integer lowerQuartile;
    private Integer median;


    public AdrByDOW(String dow, Integer min, Integer p5, Integer lowerQuartile, Integer median, Integer upperQuartile, Integer p95, Integer max, Integer avg) {
        this.dow = dow;
        this.min = min;
        this.p5 = p5;
        this.lowerQuartile = lowerQuartile;
        this.median = median;
        this.upperQuartile = upperQuartile;
        this.p95 = p95;
        this.max = max;
        this.avg = avg;
    }

    public Integer getUpperQuartile() {
        return upperQuartile;
    }

    public void setUpperQuartile(Integer upperQuartile) {
        this.upperQuartile = upperQuartile;
    }

    public Integer getLowerQuartile() {
        return lowerQuartile;
    }

    public void setLowerQuartile(Integer lowerQuartile) {
        this.lowerQuartile = lowerQuartile;
    }

    public Integer getMedian() {
        return median;
    }

    public void setMedian(Integer median) {
        this.median = median;
    }

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getP5() {
        return p5;
    }

    public void setP5(Integer p5) {
        this.p5 = p5;
    }

    public Integer getP95() {
        return p95;
    }

    public void setP95(Integer p95) {
        this.p95 = p95;
    }
}
