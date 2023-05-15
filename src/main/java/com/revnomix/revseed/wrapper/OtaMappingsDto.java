package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.model.OtaMappings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtaMappingsDto {
	
	private String domainName;
	private OtaMappings otaMappings;
	

}
