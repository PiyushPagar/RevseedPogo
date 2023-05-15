package com.revnomix.revseed.wrapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revnomix.revseed.wrapper.dashboard.OtaWiseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PerformanceDto {

    private Integer clientId;
    private String fromDate;
    private String lhsFromDate;
    private String lhsToDate;
    private String rhsFromDate;
    private String rhsToDate;
    private String toDate;
    private String otaName;
    private Integer month;
    private String year;
    private Date date;
    private BigDecimal revenue = BigDecimal.ZERO;
    private Integer room = 0;
    private Boolean isHnF;
    private List<OtaWiseDto> ota = new ArrayList<>();
    private List<Integer> otas = new ArrayList<Integer>();
    private List<Integer> selectedDay = new ArrayList<Integer>();
    private List<Integer> selectedMonth = new ArrayList<Integer>();

    public PerformanceDto(Integer room, BigDecimal revenue, Date date ,Integer clientId) {
        this.revenue = revenue;
        this.room = room;
        this.date = date;
        this.clientId = clientId;
    }
    public PerformanceDto(Integer room, BigDecimal revenue, Date date, String otaName) {
        this.revenue = revenue;
        this.room = room;
        this.date = date;
        this.otaName = otaName;
    }
    public PerformanceDto(Integer room, BigDecimal revenue, String otaName) {
        this.revenue = revenue;
        this.room = room;
        this.otaName = otaName;
    }
}
