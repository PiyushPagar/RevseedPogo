package com.revnomix.revseed.wrapper.analysis;

import java.util.*;

public class  AnalysisOtaData {

    private Set<String> categories;
    private Map<String, List<Double>> values;
    public Set<String> getCategories() {
        if (this.categories == null) {
            this.categories = new LinkedHashSet<>();
        }
        return categories;
    }

    public void setCategories(Set <String> categories) {
        this.categories = categories;
    }

    public Map<String, List<Double>> getValues() {
        if (values == null ){
            values= new LinkedHashMap<>();
        }
        return values;
    }

    public void setValues(Map<String, List<Double>> values) {
        this.values = values;
    }
}
