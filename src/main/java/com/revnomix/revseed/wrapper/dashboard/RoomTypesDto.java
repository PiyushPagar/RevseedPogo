package com.revnomix.revseed.wrapper.dashboard;

import java.util.Date;

import lombok.Data;
@Data
public class RoomTypesDto {
	private Integer id;
    private String name;
    private String description;
    private Integer author;
    private String status;
    private Date regdate;
}
