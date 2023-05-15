package com.revnomix.revseed.wrapper;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StaahRateAndRoomTypeDto {
    List<StaahRateTypeDto> roomTypes ;
    List<StaahRateTypeDto> rateTypes ;
}
