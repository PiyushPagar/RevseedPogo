package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class AlertConfigurationDto {
	private Integer id;
    private String alertType;
    private String alertTypeCode;
    private String status;
    private Integer accountId;
}
