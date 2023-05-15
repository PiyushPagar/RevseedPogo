package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class DropDownDto {
	String code;
	String codeDesc;	
	String extraParam;
	
	public DropDownDto(){}
	
	public DropDownDto(String code, String codeDesc) {
		this.code=code;
		this.codeDesc = codeDesc;
	}
	
	public DropDownDto(String code, String codeDesc,String extraParam) {
		this.code=code;
		this.codeDesc = codeDesc;
		this.extraParam = extraParam;
	}
}
