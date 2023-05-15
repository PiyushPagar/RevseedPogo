package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.wrapper.analysis.TrendByOtaDtoAndDate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class OtaDataByDateDto {
    private List<TrendByOtaDtoAndDate> tyOtaData = new ArrayList<>();
    private List<TrendByOtaDtoAndDate> lyOtaData = new ArrayList<>();
    private List<TrendByOtaDtoAndDate> stlyOtaData = new ArrayList<>();
}
