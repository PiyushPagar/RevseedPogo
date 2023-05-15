package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class BookingStatusMappingDto {
	
	private Integer id;
	private String bookingStatus;
	private String channelManager;
	private Boolean isActive;
	private String status;

}
