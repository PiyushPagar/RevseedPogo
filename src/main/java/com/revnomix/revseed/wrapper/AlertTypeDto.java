package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class AlertTypeDto {

	 private Integer id;
	 private String name;
	 private String code;
	 private String body;
	 private String subject;
	 private String status;
}
