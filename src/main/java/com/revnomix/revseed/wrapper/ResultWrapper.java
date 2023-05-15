package com.revnomix.revseed.wrapper;

import java.io.Serializable;
import java.util.List;

public class ResultWrapper<T> implements Serializable {
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
