package com.revnomix.revseed.wrapper;

public class ChannelManagerDto {
    private int hoteld;
    private String cmPassword;
    private String Username;
    private String cmMasterRoom;
    private int cmMasterRate;

    public int getHoteld() {
        return hoteld;
    }

    public void setHoteld(int hoteld) {
        this.hoteld = hoteld;
    }

    public String getCmPassword() {
        return cmPassword;
    }

    public void setCmPassword(String cmPassword) {
        this.cmPassword = cmPassword;
    }
}
