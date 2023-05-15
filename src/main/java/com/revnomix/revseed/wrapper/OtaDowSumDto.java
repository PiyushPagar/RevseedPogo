package com.revnomix.revseed.wrapper;

import java.io.Serializable;

public class OtaDowSumDto implements Serializable {

    Double total_1,total_2,total_3,total_4,total_5,total_6,total_7,avg_rate;
    Integer count;

    public OtaDowSumDto(Double total_1, Double total_2, Double total_3, Double total_4, Double total_5, Double total_6, Double total_7, Integer count, Double avg_rate) {
        this.total_1 = total_1;
        this.total_2 = total_2;
        this.total_3 = total_3;
        this.total_4 = total_4;
        this.total_5 = total_5;
        this.total_6 = total_6;
        this.total_7 = total_7;
        this.count = count;
        this.avg_rate = avg_rate;

    }

    public Double getAvg_rate() {
        return avg_rate;
    }

    public void setAvg_rate(Double avg_rate) {
        this.avg_rate = avg_rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotal_1() {
        return total_1;
    }

    public void setTotal_1(Double total_1) {
        this.total_1 = total_1;
    }

    public Double getTotal_2() {
        return total_2;
    }

    public void setTotal_2(Double total_2) {
        this.total_2 = total_2;
    }

    public Double getTotal_3() {
        return total_3;
    }

    public void setTotal_3(Double total_3) {
        this.total_3 = total_3;
    }

    public Double getTotal_4() {
        return total_4;
    }

    public void setTotal_4(Double total_4) {
        this.total_4 = total_4;
    }

    public Double getTotal_5() {
        return total_5;
    }

    public void setTotal_5(Double total_5) {
        this.total_5 = total_5;
    }

    public Double getTotal_6() {
        return total_6;
    }

    public void setTotal_6(Double total_6) {
        this.total_6 = total_6;
    }

    public Double getTotal_7() {
        return total_7;
    }

    public void setTotal_7(Double total_7) {
        this.total_7 = total_7;
    }
}
