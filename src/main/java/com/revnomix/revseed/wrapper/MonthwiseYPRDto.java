package com.revnomix.revseed.wrapper;

import java.util.List;

import lombok.Data;

@Data
public class MonthwiseYPRDto {
	private List<PerformanceDto> stlyperformanceDtoList;
	private List<PerformanceDto> typerformanceDtoList;
	private List<PerformanceDto> lyperformanceDtoList;
	private List<PerformanceDto> stlmperformanceDtoList;
	private List<PerformanceDto> sotmperformanceDtoList;
}
