package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class UILayoutDto {
	private Integer id;
    private String name;
    private String layoutType;
    private String description;
    private String uiId;
    private String status;
    private Integer parentId;
    private UILayoutDto parentLayout;
    private String hierarchy;
    private UILayoutDto childLayout;
}
