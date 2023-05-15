package com.revnomix.revseed.wrapper.analysis;

import java.util.ArrayList;
import java.util.List;

public class AdrByDowWrapper {
    private List<AdrByDOW> values;
    private String subtitle;

    public List<AdrByDOW> getValues() {
        return values;
    }

    public void setValues(List<AdrByDOW> values) {
        if (values == null){
            values = new ArrayList<>();
        }
        this.values = values;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
