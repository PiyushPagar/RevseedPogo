package com.revnomix.revseed.wrapper.analysis;

import java.util.List;
import java.util.Map;

public class RateBandWrapper {
    private List<Map<String, Integer>> values;
    private String subtitle;

    public List<Map<String, Integer>> getValues() {
        return values;
    }

    public void setValues(List<Map<String, Integer>> values) {
        this.values = values;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
