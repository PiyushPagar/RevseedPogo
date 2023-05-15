package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class PermissionsDto {

	private Integer id;
	private Integer clientId; 
	private Integer accountId;
	private Integer uiLayoutId;
	private UILayoutDto parentLayout;
	private Boolean isEditable;
	private Boolean isDisable;
	private String roleCustom;
	private String status;
	private String hierarchy;
    private String uiLayoutName;
    private String layoutType;
    private String description;
    private String uiId;
    private Integer parentId;
    private Boolean isPredefined;
}
