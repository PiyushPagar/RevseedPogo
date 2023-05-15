package com.revnomix.revseed.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmMigrationDto {
	private Integer clientId;
	private String channelManager;
	private Integer cmHotel;
	private String cmUsername;
	private String cmPassword;
	private String isMax;
	private String isDeleteBooking;
}
