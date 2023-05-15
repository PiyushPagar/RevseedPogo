package com.revnomix.revseed.wrapper;

import java.util.Date;
import lombok.Data;

@Data
public class SystemDateDto {
	private Date systemToday;
	private Date yesterday;
	private Date firstDateofMonth;
	private Date lastDateofMonth;
	private Date lastMonthFirstDate;
	private Date lastMonthlastDate;
}
