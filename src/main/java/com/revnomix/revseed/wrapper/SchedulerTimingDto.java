package com.revnomix.revseed.wrapper;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SchedulerTimingDto {

	private Long id;
	private Long clientId;
	private ArrayList<String> timings;
	private String caliberationTiming;
	private Boolean toggleflag;
}
