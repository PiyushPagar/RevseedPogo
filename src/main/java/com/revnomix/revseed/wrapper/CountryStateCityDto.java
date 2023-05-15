package com.revnomix.revseed.wrapper;

import lombok.Data;

@Data
public class CountryStateCityDto {
	private Integer id;
    private String name;
    private String code;
    private String type;
    private String phoneCode;
    private String currency;
    private String status;
    private Integer parentId;
    private CountryStateCityDto parentSts;
    private String hierarchy;
    private CountryStateCityDto childSts;
}
