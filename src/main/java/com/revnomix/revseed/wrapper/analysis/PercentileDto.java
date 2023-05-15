package com.revnomix.revseed.wrapper.analysis;

public class PercentileDto {
    Integer prank;
    Integer adr;

    public PercentileDto(Integer prank, Integer adr) {
        this.prank = prank;
        this.adr = adr;
    }

    public Integer getPrank() {
        return prank;
    }

    public void setPrank(Integer prank) {
        this.prank = prank;
    }

    public Integer getAdr() {
        return adr;
    }

    public void setAdr(Integer adr) {
        this.adr = adr;
    }
}
