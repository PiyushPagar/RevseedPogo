package com.revnomix.revseed.wrapper;

import java.util.List;

import lombok.Data;

@Data
public class DowCalendarDto {
	private List<Integer> weekNo;
	private List<DowWeekendDto> weekendArr;
	private Integer clientId;
	private Integer season;
	private Integer week;
}
