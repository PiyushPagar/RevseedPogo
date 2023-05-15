package com.revnomix.revseed.wrapper;

import com.revnomix.revseed.model.Otas;

import java.io.Serializable;
import java.util.List;

public class PatternAnalysisDto implements Serializable {
    List<Otas> otas;
    Boolean status = true;
    AnalysisDto analysis;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AnalysisDto getAnalysis() {
        return analysis;
    }

    public void setAnalysis(AnalysisDto analysis) {
        this.analysis = analysis;
    }

      public List<Otas> getOtas() {
        return otas;
    }
    public void setOtas(List<Otas> otas) {
        this.otas = otas;
    }
}
