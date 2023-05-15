package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class AlertConditionTypeDto {
	private Integer id;
    private Integer configId;
    private String startDate;
    private String endDate;
    private Integer startWindow;
    private Integer endWindow;
    private Integer interval;
    private String intervalType;
    private String status;
}
