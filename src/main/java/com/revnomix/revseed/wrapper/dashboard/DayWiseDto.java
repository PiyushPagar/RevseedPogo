package com.revnomix.revseed.wrapper.dashboard;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DayWiseDto {

	private Integer day;
    private BigDecimal revenue = BigDecimal.ZERO;
    private Integer room = 0;
}
