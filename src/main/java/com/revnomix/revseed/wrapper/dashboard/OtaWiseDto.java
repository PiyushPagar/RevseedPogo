package com.revnomix.revseed.wrapper.dashboard;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtaWiseDto {

    private String otaName;
    private List<DayWiseDto> dayWiseDto;
}
