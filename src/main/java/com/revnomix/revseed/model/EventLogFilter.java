package com.revnomix.revseed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventLogFilter {
    private String source;
    private String action;
    private String message;
    private Integer accountId;
    private String ipAddress;
    private Integer clientId;
    private String fromDate;
    private String toDate;
}
